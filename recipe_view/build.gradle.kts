import Dependencies.AndroidX
import Dependencies.Coroutines
import Dependencies.DI
import Dependencies.FlowBinding
import Dependencies.TestLibraires
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
    id("kotlin-android")
    safeArgs
    daggerHilt
}

android {
    defaultConfig {
        compileSdkVersion(BuildConfig.Versions.compile)
        minSdkVersion(BuildConfig.Versions.min)
        targetSdkVersion(BuildConfig.Versions.target)
        testInstrumentationRunner = BuildConfig.Android.testInstrumentationRunner
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(core))
    implementation(project(domain))
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation(project(testUtils))
    androidTestImplementation(project(testUtils))

    with(View) {
        implementAll(components)
        implementation(fragment)
        implementation(materialComponent)
        implementation(constraintLayout)
        implementation(recyclerView)
        implementation(shimmerLayout)
        implementation(glide)
    }

    implementation(FlowBinding.android)
    implementation(DI.hiltAndroid)
    implementation(DI.hiltViewModel)
    implementAll(AndroidX.components)
    implementAll(Coroutines.components)

    kapt(View.AnnotationProcessor.glide)

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