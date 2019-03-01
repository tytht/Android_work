#include <stdio.h>  
#include <jni.h> 


jint create_vm(JavaVM** jvm, JNIEnv** env) 
{  
    JavaVMInitArgs args;  
    JavaVMOption options[1];  
    args.version = JNI_VERSION_1_6;  /*创建1.6版本的java虚拟机*/
    args.nOptions = 1;  
    options[0].optionString = "-Djava.class.path=./"; /*在当前目录下查找类*/
    args.options = options;  
    args.ignoreUnrecognized = JNI_FALSE;  
    return JNI_CreateJavaVM(jvm, (void **)env, &args);  
}  


int main(int argc, char **argv)
{
	JavaVM* jvm;
	JNIEnv* env;

	jclass cls;
	int ret = 0;

	jmethodID mid;
	jmethodID cid;

	jobject jobj;
	jstring jstr;

	jfieldID nameID;
	jfieldID ageID;

	int r;
		
	/* 1. create java virtual machine */
	if (create_vm(&jvm, &env)) {
		printf("can not create jvm\n");
		return -1;
	}

	/* 2. get class */
	cls = (*env)->FindClass(env, "Hello"); /*获取Hello类对象*/
	if (cls == NULL) {
		printf("can not find hello class\n");
		ret = -1;
		goto destroy;
	}

	/* 3. create object 
	 * 3.1 get constructor method
	 * 3.2 create parameters
	 * 3.3 NewObject
	 * 注意：调用类的静态成员方法的时候不需要实例化对象
	 */

	/*<init>表示获取构造方法，构造函数的签名可以用javap -p -s Hello.class查看*/
	/* Get the method ID for the String constructor */
	cid = (*env)->GetMethodID(env, cls,	"<init>", "()V");
	if (cid == NULL) {
		ret = -1;
		printf("can not get constructor method");
		goto destroy;
	}

	/*调用类的构造函数实例化一个对象*/
	jobj = (*env)->NewObject(env, cls, cid);
	if (jobj == NULL) {
		ret = -1;
		printf("can not create object");
		goto destroy;
	}

	/* get/set field
	 * 1. get field id
	 * 2. get/set field
	 */
	
	/*设置Hello类对象的name属性，arg4是属性的签名*/
	nameID = (*env)->GetFieldID(env, cls, "name", "Ljava/lang/String;");
	if (nameID == NULL) {
		ret = -1;
		printf("can not get field name");
		goto destroy;
	}
	jstr = (*env)->NewStringUTF(env, "Bill");
	(*env)->SetObjectField(env, jobj, nameID, jstr); /*将name属性设置为“Bill”*/

	/*设置Hello类对象的age属性*/
	ageID = (*env)->GetFieldID(env, cls, "age", "I");
	if (ageID == NULL) {
		ret = -1;
		printf("can not get field age");
		goto destroy;
	}
	(*env)->SetIntField(env, jobj, ageID, 10);

	/* 4. call method
	 * 4.1 get method
	 * 4.2 create parameter
	 * 4.3 call method
	 */

	/*调用Java程序中的“sayhello_to”成员方法id*/
	mid = (*env)->GetMethodID(env, cls, "sayhello_to","(Ljava/lang/String;)I");
	if (mid == NULL) {
		ret = -1;
		printf("can not get method\n");
		goto destroy;
	}

	jstr = (*env)->NewStringUTF(env, "abcd@qq.com");

	/*调用Java程序中的“sayhello_to”成员方法并获取返回值。
	 * 对比静态方法:
	 * 这里是CallIntMethod()且其参数是对象
	 * eg: static void main()是调用CallStaticVoidMethod()且参数是类
	 */
	r = (*env)->CallIntMethod(env, jobj, mid, jstr);
	/*打印Java程序中的“sayhello_to”成员方法的返回值*/
	printf("ret = %d\n", r);

destroy:

	(*jvm)->DestroyJavaVM(jvm);
	return ret;
}

