#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

JNIEXPORT jstring JNICALL Java_fr_tp_nombrepremier_MainActivity_stringPremier(JNIEnv *env, jobject obj, jint value)
{
	long j;

	if(value == 1)
		return (*env)->NewStringUTF(env, "Il N'est PAS premier !");

	if (value % 2 == 0)
		return (*env)->NewStringUTF(env, "Il N'est PAS premier !");

	for (j = 3; j * j <= value; j = j + 2)
		if (value % j == 0)
			return (*env)->NewStringUTF(env, "Il N'est PAS premier !");

	return (*env)->NewStringUTF(env, "Il EST premier ! ! !");
}
