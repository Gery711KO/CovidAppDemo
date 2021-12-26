import org.gradle.api.artifacts.dsl.DependencyHandler

const val coroutinesVersion = "1.5.2"
const val kotlinVersion = "1.6.0"

private object CommonVersions {
    const val navigation = "2.3.5"
}

object AndroidSdk {
    const val minApi = 23
    const val compileApi = 31
    const val targetApi = compileApi
    const val buildTools = "32.0.0"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "7.0.4"
        const val googleServicesVersion = "4.3.10"
    }

    const val androidBuildTools = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val safeArgsGradle =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${CommonVersions.navigation}"

    const val kotlinAndroidPlugin = "kotlin-android"
    const val googleServicesPlugin = "com.google.gms.google-services"
    const val kotlinAndroidExtensionsPlugin = "kotlin-android-extensions"
    const val kotlinAndroidKaptPlugin = "kotlin-kapt"
    const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
}

object Network {
    private object Versions {
        const val okHttp = "4.9.2"
        const val retrofit = "2.9.0"
        const val moshi = "1.12.0"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiAdapter = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshiGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object Firebase {
    private object Versions {
        // cannot upgrade bom to newer until this is fixed:
        // https://youtrack.jetbrains.com/issue/KT-44375
        const val bom = "29.0.3"
        const val invites = "17.0.0"
    }

    const val firebase = "com.google.firebase:firebase-bom:${Versions.bom}"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val auth = "com.google.firebase:firebase-auth-ktx"
    const val invites = "com.google.firebase:firebase-invites:${Versions.invites}"
    const val storage = "com.google.firebase:firebase-storage-ktx"
    const val config = "com.google.firebase:firebase-config-ktx"
}


object AndroidX {
    private object Versions {
        const val appcompat = "1.4.0"
        const val lifecycle = "2.4.0"
        const val lifecycleExt = "2.2.0"
        const val constraint = "2.1.1"
        const val ktx = "1.7.0"
        const val swiperefresh = "1.1.0"
        const val viewPager2 = "1.0.0"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefresh}"

    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment:${CommonVersions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${CommonVersions.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${CommonVersions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${CommonVersions.navigation}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
}

object AdapterDelegates {
    private const val adapterDelegatesVersion = "4.3.0"

    const val adapterdelegates4 =
        "com.hannesdorfmann:adapterdelegates4:${adapterDelegatesVersion}"
    const val adapterdelegates4dsl =
        "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${adapterDelegatesVersion}"
    const val adapterdelegates4dslLayoutcontainer =
        "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:${adapterDelegatesVersion}"
    const val adapterdelegates4dslViewbinding =
        "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${adapterDelegatesVersion}"
}

fun DependencyHandler.adapter() {
    addDependency(AdapterDelegates.adapterdelegates4)
    addDependency(AdapterDelegates.adapterdelegates4dsl)
    addDependency(AdapterDelegates.adapterdelegates4dslLayoutcontainer)
    addDependency(AdapterDelegates.adapterdelegates4dslViewbinding)
}


object Libraries {
    private object Versions {
        const val material = "1.5.0-rc01"
        const val koin = "3.1.3"
        const val timber = "5.0.1"
        const val room = "2.4.0"
        const val jsoup = "1.14.3"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
    const val koinNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomComp = "androidx.room:room-compiler:${Versions.room}"
    const val roomCoroutine = "androidx.room:room-ktx:${Versions.room}"

    const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"
}

object TestLibraries {
    private object Versions {
        const val ju4 = "4.13.1"
        const val junitExt = "1.1.1"
        const val testRunner = "1.3.0"
        const val espresso = "3.3.0"
        const val mockk = "1.10.5"
        const val mockitoKotlin = "2.2.0"
    }

    const val junit4 = "junit:junit:${Versions.ju4}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val junitExtKtx = "androidx.test.ext:junit-ktx:${Versions.junitExt}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoIdle = "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
    const val coroutinesTesting = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
    const val testing = "androidx.test:core:${Versions.testRunner}"
    const val testingKtx = "androidx.test:core-ktx:${Versions.testRunner}"
    const val mockk = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
}

fun DependencyHandler.kotlinProject() {
    addDependency(Libraries.kotlinStdLib, DependencyConfig.Api)
    addDependency(Libraries.kotlinReflect, DependencyConfig.Api)
    addDependency(Libraries.coroutines, DependencyConfig.Api)
    addDependency(Libraries.coroutinesPlayServices, DependencyConfig.Api)
    addDependency(Libraries.room, DependencyConfig.Api)
    addDependency(Libraries.roomComp, DependencyConfig.Api)
    addDependency(Libraries.roomCoroutine, DependencyConfig.Api)
    addDependency(Libraries.jsoup, DependencyConfig.Api)
}

fun DependencyHandler.navigation(config: DependencyConfig = DependencyConfig.Implementation) {
    addDependency(AndroidX.navigationFragment)
    addDependency(AndroidX.navigationFragmentKtx)
    addDependency(AndroidX.navigationUi)
    addDependency(AndroidX.navigationUiKtx)
}

fun DependencyHandler.androidX(config: DependencyConfig = DependencyConfig.Implementation) {
    addDependency(AndroidX.lifecycleExt, config)
    addDependency(AndroidX.lifecycleLiveDataKtx, config)
    addDependency(AndroidX.lifecycleRuntimeKtx, config)
    addDependency(AndroidX.lifecycleViewModelKtx, config)

    addDependency(AndroidX.appCompat, config)
    addDependency(AndroidX.constraintLayout, config)
    addDependency(AndroidX.ktxCore, config)
}

fun DependencyHandler.firebase() {
    addDependency(platform(Firebase.firebase))
    addDependency(Firebase.analytics)
    addDependency(Firebase.crashlytics)
}

fun DependencyHandler.network(config: DependencyConfig = DependencyConfig.Api) {
    addDependency(Network.okhttp, config)
    addDependency(Network.interceptor, config)
    addDependency(Network.retrofit, config)
    moshi(config)
}

fun DependencyHandler.moshi(config: DependencyConfig = DependencyConfig.Implementation) {
    addDependency(Network.moshi, config)
    addDependency(Network.moshiAdapter, config)
    addDependency(Network.moshiConverter, config)
    addDependency(Network.moshiGen, DependencyConfig.Kapt)
}

fun DependencyHandler.koin(config: DependencyConfig = DependencyConfig.Implementation) {
    addDependency(Libraries.koinCore, config)
    addDependency(Libraries.koinNavigation, config)
    addDependency(Libraries.koinWorkManager, config)
}

fun DependencyHandler.unitTests() {
    addDependency(TestLibraries.junit4, DependencyConfig.Test)
    addDependency(TestLibraries.coroutinesTesting, DependencyConfig.Test)
    addDependency(TestLibraries.testing, DependencyConfig.Test)
    addDependency(TestLibraries.mockk, DependencyConfig.Test)
    addDependency(TestLibraries.testRunner, DependencyConfig.Test)
    addDependency(TestLibraries.junitExt, DependencyConfig.Test)
}

fun DependencyHandler.uiTests() {
    addDependency(TestLibraries.testRunner, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.testRules, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.espresso, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.testing, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.testingKtx, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.mockk, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.coroutinesTesting, DependencyConfig.AndroidTest)
    addDependency(Libraries.koinTest, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.junitExt, DependencyConfig.AndroidTest)
    addDependency(TestLibraries.junitExtKtx, DependencyConfig.AndroidTest)
}

fun DependencyHandler.addDependency(
    depName: Any,
    config: DependencyConfig = DependencyConfig.Implementation
) {
    add(config.configName, depName)
}