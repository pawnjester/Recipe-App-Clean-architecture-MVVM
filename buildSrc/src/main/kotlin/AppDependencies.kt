import Dependencies.View.Versions.fragment

const val kotlinAndroid: String = "android"
const val kotlinAndroidExtension: String = "android.extensions"
const val kotlinKapt: String = "kapt"
const val ktLintVersion: String = "0.36.0"

object BuildConfig {

    object Versions {
        const val min = 24
        const val compile = 30
        const val target = compile
        const val versionCode = 1
        const val versionName = "1.0"
    }

    const val isMultiDexEnabled: Boolean = true

    object Android {
        const val applicationId: String = "com.example.recipeapplication"
        const val testInstrumentationRunner: String = "androidx.test.runner.AndroidJUnitRunner"
    }

}

interface Libraries {
    val components: List<String>
}

object Dependencies {
    object AndroidX : Libraries {
        object Versions {
            const val navigationComponent: String = "2.3.1"
            const val coreKTx: String = "1.5.0-alpha02"
            const val multidex: String = "2.0.1"
            const val lifeCycle: String = "2.3.0-alpha07"
            const val activity: String = "1.2.0-alpha08"
        }

        const val navigationFragmentKtx: String =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
        const val navigationUiKtx: String =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"
        const val multiDex: String = "androidx.multidex:multidex:${Versions.multidex}"
        const val activity: String = "androidx.activity:activity:${Versions.activity}"
        const val lifeCycleCommon: String =
            "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycle}"
        const val viewModel: String =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
        const val coreKtx: String = "androidx.core:core-ktx:${Versions.coreKTx}"

        const val liveData: String = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"

        override val components: List<String>
            get() = listOf(
                coreKtx, navigationFragmentKtx, navigationUiKtx, multiDex, activity,
                lifeCycleCommon, viewModel, liveData
            )

    }

    object View : Libraries {
        object Versions {
            const val materialComponent: String = "1.3.0-alpha02"
            const val shimmerLayout: String = "0.5.0"
            const val constraintLayout = "2.0.2"
            const val recyclerView = "1.2.0-alpha05"
            const val appCompat: String = "1.3.0-alpha02"
            const val fragment: String = "1.3.0-alpha08"
            const val glide: String = "4.11.0"
        }

        object AnnotationProcessor {
            const val glide: String = "com.github.bumptech.glide:compiler:${Versions.glide}"
        }


        const val glide: String = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val recyclerView: String =
            "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val constraintLayout: String =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val appCompat: String = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val fragment: String = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val shimmerLayout: String = "com.facebook.shimmer:shimmer:${Versions.shimmerLayout}"
        const val materialComponent: String =
            "com.google.android.material:material:${Versions.materialComponent}"

        override val components: List<String>
            get() = listOf(appCompat, fragment)
    }

    object Others {
        object Versions {
            const val jodaTime: String = "2.9.9.4"
        }

        const val jodaTime: String = "net.danlew:android.joda:${Versions.jodaTime}"
    }

    object FlowBinding {
        private const val flowBinding: String = "1.0.0-alpha04"
        const val android: String =
            "io.github.reactivecircus.flowbinding:flowbinding-android:$flowBinding"
        const val lifecycle: String =
            "io.github.reactivecircus.flowbinding:flowbinding-lifecycle:$flowBinding"
    }

    object DI {
        object Versions {
            const val javaxInject: String = "1"
            const val hiltAndroid: String = "2.28.3-alpha"
            const val hiltViewModel: String = "1.0.0-alpha02"
        }

        object AnnotationProcessor {
            const val hiltAndroid: String =
                "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
            const val hiltCompiler: String = "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"
        }

        const val javaxInject: String = "javax.inject:javax.inject:${Versions.javaxInject}"
        const val hiltAndroid: String = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val hiltViewModel: String =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
        const val hiltTesting: String =
            "com.google.dagger:hilt-android-testing:${Versions.hiltAndroid}"
    }

    object Coroutines : Libraries {
        object Versions {
            const val coroutines: String = "1.3.9"
        }

        const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val androidCoroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

        override val components: List<String>
            get() = listOf(core, androidCoroutines)
    }

    object TestLibraires {

        object Versions {
            const val jUnit4 = "4.13.1"
            const val runner: String = "1.3.0"
            const val rules: String = "1.3.0"
            const val testExt: String = "1.1.2"
            const val espresso = "3.3.0"
            const val truth: String = "1.0.1"
            const val robolectric: String = "4.4"
            const val archCoreTest: String = "1.1.1"
        }

        const val espresso: String = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val junit: String = "junit:junit:${Versions.jUnit4}"
        const val robolectric: String = "org.robolectric:robolectric:${Versions.robolectric}"
        const val coroutinesTest: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Coroutines.Versions.coroutines}"
        const val truth: String = "com.google.truth:truth:${Versions.truth}"
        const val androidXTest: String = "androidx.test.ext:junit:${Versions.testExt}"
        const val fragmentTesting: String = "androidx.fragment:fragment-testing:$fragment"
        const val espressoContrib: String =
            "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
        const val rules: String = "androidx.test:rules:${Versions.rules}"
        const val runner: String = "androidx.test:runner:${Versions.runner}"
        const val archCoreTest: String = "android.arch.core:core-testing:${Versions.archCoreTest}"
    }

    object Cache {
        object Versions {
            const val roomVersion = "2.3.0-alpha02"
            const val gsonVersion = "2.8.6"
        }

        object AnnotationProcessor {
            const val room: String = "androidx.room:room-compiler:${Versions.roomVersion}"
        }

        const val room: String = "androidx.room:room-ktx:${Versions.roomVersion}"
        const val gson: String = "com.google.code.gson:gson:${Versions.gsonVersion}"
    }

    object Remote {
        object Versions {
            const val retrofitVersion = "2.9.0"
            const val okHttp = "4.9.0"


        }

        const val retrofit: String = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitConversion: String =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
        const val okHttp: String = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    }

}

object ProjectLib {
    const val app: String = ":app"
    const val core: String = ":core"
    const val presentation: String = ":presentation"
    const val domain: String = ":domain"
    const val data: String = ":data"
    const val cache: String = ":cache"
    const val testUtils: String = ":testUtils"
    const val recipeView: String = ":recipe_view"
    const val remote: String = ":remote"
}
