import Dependencies.Cache
import Dependencies.DI
import Dependencies.TestLibraires
import Dependencies.Remote
import ProjectLib.data
import ProjectLib.remote
import ProjectLib.testUtils


plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {
    defaultConfig {
        minSdkVersion(BuildConfig.Versions.min)
        compileSdkVersion(BuildConfig.Versions.compile)
        targetSdkVersion(BuildConfig.Versions.target)

        buildConfigField("String", "BASE_URL_API", "\"https://api.spoonacular.com/\"")
    }

    buildTypes {
        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility= JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(project(data))
    implementation(project(testUtils))
    implementation(project(remote))

    implementation(DI.hiltAndroid)
    implementation(Remote.retrofit)
    implementation(Remote.okHttp)
    implementation(Remote.okHttpLoggingInterceptor)
    implementation(Remote.retrofitConversion)
    api(Cache.room)

    testImplementation(TestLibraires.runner)
    testImplementation(TestLibraires.androidXTest)
    testImplementation(TestLibraires.robolectric)

    kapt(Cache.AnnotationProcessor.room)
    kapt(DI.AnnotationProcessor.hiltAndroid)
}