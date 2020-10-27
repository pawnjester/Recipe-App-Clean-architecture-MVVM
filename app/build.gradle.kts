import Dependencies.AndroidX
import Dependencies.DI
import Dependencies.Others
import Dependencies.View
import ProjectLib.cache
import ProjectLib.core
import ProjectLib.data
import ProjectLib.domain
import ProjectLib.presentation
import ProjectLib.recipeView

plugins {
    androidApplication
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    safeArgs
    daggerHilt
}

android {

    defaultConfig {
        applicationId = Config.Android.applicationId
        compileSdkVersion(Config.Android.compile)
        minSdkVersion(Config.Versions.min)
        targetSdkVersion(Config.Versions.target)
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName
        multiDexEnabled = Config.isMultiDexEnabled
        testInstrumentationRunner = Config.Android.testInstrumentationRunner
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

    implementAll(View.components)
    implementation(DI.hiltAndroid)
    implementation(DI.hiltViewModel)
    implementation(Others.jodaTime)

    AndroidX.run {
        implementation(activity)
        implementation(coreKtx)
        implementation(navigationFragmentKtx)
        implementation(navigationUiKtx)
        implementation(multiDex)
    }

    kapt(DI.AnnotationProcessor.hiltAndroid)
    kapt(DI.AnnotationProcessor.hiltCompiler)
}