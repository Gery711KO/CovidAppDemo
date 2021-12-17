import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}