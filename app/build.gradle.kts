import Dependencies.AndroidX
import Dependencies.DI
import Dependencies.Others
import Dependencies.View
import Dependencies.Remote
import ProjectLib.cache
import ProjectLib.core
import ProjectLib.data
import ProjectLib.domain
import ProjectLib.presentation
import ProjectLib.recipeView
import ProjectLib.remote

plugins {
    androidApplication
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    safeArgs
    daggerHilt
}

android {
    defaultConfig {
        applicationId = BuildConfig.Android.applicationId
        compileSdkVersion(30)
        minSdkVersion(BuildConfig.Versions.min)
        targetSdkVersion(BuildConfig.Versions.target)
        versionCode = BuildConfig.Versions.versionCode
        versionName = BuildConfig.Versions.versionName
        multiDexEnabled = BuildConfig.isMultiDexEnabled
        testInstrumentationRunner = BuildConfig.Android.testInstrumentationRunner
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(recipeView))
    implementation(project(cache))
    implementation(project(presentation))
    implementation(project(domain))
    implementation(project(data))
    implementation(project(core))
    implementation(project(remote))

    implementAll(View.components)
    implementation(DI.hiltAndroid)
    implementation(DI.hiltViewModel)
    implementation(Others.jodaTime)
    implementation(Remote.retrofit)
    implementation(Remote.okHttp)
    implementation(Remote.okHttpLoggingInterceptor)
    implementation(Remote.retrofitConversion)

    AndroidX.run {
        implementation(activity)
        implementation(coreKtx)
        implementation(liveData)
        implementation(navigationFragmentKtx)
        implementation(navigationUiKtx)
        implementation(multiDex)
    }

    kapt(DI.AnnotationProcessor.hiltAndroid)
    kapt(DI.AnnotationProcessor.hiltCompiler)
}