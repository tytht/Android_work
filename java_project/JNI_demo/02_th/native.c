#include <stdio.h>
#include <jni.h>

#if 1
/*
typedef struct {
    char *name;
    char *signature;
    void *fnPtr;
} JNINativeMethod;
*/

jstring c_hello(JNIEnv *env, jobject cls, jstring str) {
	const jbyte *cstr;
	cstr = (*env)->GetStringUTFChars(env, str, NULL);
	printf("Get string from java :%s\n", cstr);
	(*env)->ReleaseStringUTFChars(env, str, cstr);
	return (*env)->NewStringUTF(env, "return from c");
}


static const JNINativeMethod methods[] = {
	{"hello", "(Ljava/lang/String;)Ljava/lang/String;", (void *)c_hello},
};



JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
	JNIEnv *env;
	jclass cls;

	if ((*vm)->GetEnv(vm, (void **)&env, JNI_VERSION_1_4)) {
		return JNI_ERR; /* JNI version not supported */
	}

	cls = (*env)->FindClass(env, "JNIDemo");
	if (cls == NULL) {
		return JNI_ERR;
	}

	/* 2. map java hello <-->c c_hello */
	if ((*env)->RegisterNatives(env, cls, methods, 1) < 0)
		return JNI_ERR;

	return JNI_VERSION_1_4;
}
#endif


#if 0
//JNIEXPORT jint JNICALL Java_JNIDemo_hello(JNIEnv *env, jobject obj, jint a) {
jint JNICALL Java_JNIDemo_hello(JNIEnv *env, jobject obj, jint a) {
	printf("Hello JNI, a=%d\n", a);
	return 222;
}
#endif













