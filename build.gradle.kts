// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.androidBuildTools)
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.safeArgsGradle)
        classpath(BuildPlugins.googleServices)
        classpath(BuildPlugins.firebaseCrashlytics)
        classpath(BuildPlugins.firebasePerformance)
        classpath(BuildPlugins.firebaseTools)
        classpath(BuildPlugins.firebaseAppDistribution)
        //classpath("com.linkedin.dexmaker:dexmaker:2.21.0")
    }
}
allprojects {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
}
