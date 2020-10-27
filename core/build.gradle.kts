import Dependencies.AndroidX
import Dependencies.Coroutines
import Dependencies.DI
import Dependencies.View
import ProjectLib.domain
import ProjectLib.data

plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {
    defaultConfig {
        minSdkVersion (Config.Versions.min)
        targetSdkVersion (Config.Versions.target)
        compileSdkVersion(Config.Versions.compile)
        testInstrumentationRunner = Config.Android.testInstrumentationRunner
    }

    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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