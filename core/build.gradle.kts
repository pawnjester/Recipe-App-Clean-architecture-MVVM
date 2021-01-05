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

    implementation(Dependencies.AndroidX.lifeCycleCommon)
    implementation(Dependencies.View.appCompat)
    implementation(Dependencies.View.fragment)
    implementation(Dependencies.DI.hiltAndroid)
    implementation(Dependencies.Coroutines.core)

    kapt(Dependencies.DI.AnnotationProcessor.hiltAndroid)

}