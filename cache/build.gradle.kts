import Dependencies.Cache
import Dependencies.DI
import Dependencies.TestLibraires
import ProjectLib.data
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

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.plusAssign(Pair("room.incremental", "true"))
            }
        }
        buildConfigField("int", "databaseVersion", 1.toString())
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

    implementation(DI.hiltAndroid)
    implementation(Cache.gson)
    api(Cache.room)

    testImplementation(TestLibraires.runner)
    testImplementation(TestLibraires.androidXTest)
    testImplementation(TestLibraires.robolectric)

    kapt(Cache.AnnotationProcessor.room)
    kapt(DI.AnnotationProcessor.hiltAndroid)
}