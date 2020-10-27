import Dependencies.AndroidX
import Dependencies.Coroutines
import Dependencies.DI
import Dependencies.FlowBinding
import Dependencies.Test
import Dependencies.View
import ProjectLib.core
import ProjectLib.domain
import ProjectLib.presentation
import ProjectLib.testUtils


plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinAndroidExtension)
    kotlin(kotlinKapt)
    safeArgs
    daggerHilt
}

android {

    defaultConfig {
        compileSdkVersion(Config.Versions.compile)
        minSdkVersion(Config.Versions.min)
        targetSdkVersion(Config.Versions.target)

        testInstrumentationRunner = Config.Android.testInstrumentationRunner
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(project(core))
    implementation(project(presentation))
    implementation(project(domain))

    testImplementation(project(testUtils))
    androidTestImplementation(project(testUtils))

    with(View) {
        implementAll(components)
        implementation(fragment)
        implementation(materialComponent)
        implementation(constraintLayout)
        implementation(recyclerView)
        implementation(shimmerLayout)
    }

    implementation(FlowBinding.android)
    implementation(DI.hiltAndroid)
    implementation(DI.hiltViewModel)
    implementAll(AndroidX.components)
    implementAll(Coroutines.components)

    kapt(DI.AnnotationProcessor.hiltAndroid)
    kapt(DI.AnnotationProcessor.hiltCompiler)

    androidTestImplementation(DI.hiltTesting)
    androidTestImplementation(TestLibraires.espresso)
    androidTestImplementation(TestLibraires.espressoContrib)
    androidTestImplementation(TestLibraires.fragmentTesting)
    androidTestImplementation(TestLibraires.rules)
    androidTestImplementation(TestLibraires.archCoreTest)

    androidTestImplementation(TestLibraires.runner)
    androidTestImplementation(TestLibraires.androidXTest)

    kaptAndroidTest(DI.AnnotationProcessor.hiltAndroid)
    kaptAndroidTest(DI.AnnotationProcessor.hiltCompiler)
}