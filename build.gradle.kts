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
    }
}
allprojects {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
}
