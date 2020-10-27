import Dependencies.AndroidX
import Dependencies.Coroutines
import Dependencies.DI
import Dependencies.View
import ProjectLib.data
import ProjectLib.domain

plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {
    compileSdkVersion(BuildConfig.Versions.compile)
    defaultConfig {
        minSdkVersion(BuildConfig.Versions.min)
        targetSdkVersion(BuildConfig.Versions.target)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }
}

dependencies {
    implementation(project(data))
    implementation(project(domain))

    implementation(AndroidX.lifeCycleCommon)
    implementation(View.appCompat)
    implementation(View.fragment)
    implementation(DI.hiltAndroid)
    implementation(Coroutines.core)

    kapt(DI.AnnotationProcessor.hiltAndroid)

}