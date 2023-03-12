buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

// TODO: migrate to "plugins"

// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    alias()
//
//
//
//
//    id 'com.android.application' version '7.4.2' apply false
//    id 'com.android.library' version '7.4.2' apply false
//    id 'org.jetbrains.kotlin.android' version '1.7.0' apply false
//    id 'org.jetbrains.kotlin.jvm' version '1.8.0' apply false
//}