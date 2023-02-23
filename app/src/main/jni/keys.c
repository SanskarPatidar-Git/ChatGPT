#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getDevBaseUrl(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "https://admin.bidfrail.com/DevTeam/api/");
}

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getDevApiKey(JNIEnv *env, jobject instance) {
 return (*env)->NewStringUTF(env, "WVU0wlcOToqPMVToHYEU4cHQD-iv2a3_lVFIz5hspkvevvM");
}

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getDevBearerAuthenticationToken(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "Bearer EUifiRBkKG5E2XzMDjRfl76ZC9Ub0wnz4XsNiRVBChTYbJcE2aVFIz5hspkvevvM");
}

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getProdBaseUrl(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "https://admin.bidfrail.com/DevTeam/api/");
}

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getProdApiKey(JNIEnv *env, jobject instance) {
 return (*env)->NewStringUTF(env, "WVU0wlcOToqPMVToHYEU4cHQD-iv2a3_lVFIz5hspkvevvM");
}

JNIEXPORT jstring JNICALL
Java_com_chatgpt_android_AppConstants_getProdBearerAuthenticationToken(JNIEnv *env, jobject instance) {
 return (*env)->  NewStringUTF(env, "Bearer EUifiRBkKG5E2XzMDjRfl76ZC9Ub0wnz4XsNiRVBChTYbJcE2aVFIz5hspkvevvM");
}