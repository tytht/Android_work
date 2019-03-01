#include <stdio.h>
#include <jni.h>

#if 0
/*
typedef struct {
    char *name;
    char *signature;
    void *fnPtr;
} JNINativeMethod;
*/

jint c_hello(JNIEnv *env, jclass cls, jint a) {
	printf("Hello JNI, a=%d\n", a);
	return 222;
}

static const JNINativeMethod methods[] = {
	{"hello", "(I)I", (void *)c_hello},
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


//JNIEXPORT jint JNICALL Java_JNIDemo_hello(JNIEnv *env, jobject obj, jint a) {
jint JNICALL Java_JNIDemo_hello(JNIEnv *env, jobject obj, jint a) {
	printf("Hello JNI, a=%d\n", a);
	return 222;
}














