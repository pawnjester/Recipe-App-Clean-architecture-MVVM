import Dependencies.Cache
import Dependencies.DI
import Dependencies.TestLibraires


plugins {
    androidLibrary
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
}

android {
    compileSdkVersion 30

    defaultConfig {
        minSdkVersion(Config.Version.min)
        compileSdkVersion(Config.Version.compile)
        targetSdkVersion(Config.Version.target)

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.plusAssign(Pair("room.incremental", "true"))
            }
        }
        buildConfigField("int", "databaseVersion", 1.toString())
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
    api(Cache.room)

    testImplementation(TestLibraires.runner)
    testImplementation(TestLibraires.androidXTest)
    testImplementation(TestLibraires.robolectric)

    kapt(Cache.AnnotationProcessor.room)
    kapt(DI.AnnotationProcessor.hiltAndroid)
}