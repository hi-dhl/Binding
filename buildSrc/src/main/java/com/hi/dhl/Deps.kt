package com.hi.dhl

import org.gradle.api.JavaVersion

object Versions {
    val junit = "4.12"

    val kotlinVersion = "1.4.21"
    val gradleVersion = "4.1.1"

    val fragment = "1.2.5"
    val viewmodel = "2.2.1"
    val navigation = "2.3.2"
    val constraintlayout = "2.0.4"
    val material = "1.2.1"
    val appcompat = "1.2.0"
    val coreKtx = "1.3.2"
    val coil = "1.1.0"
    val binding = "1.1.3"
    val baseRecyclerViewAdapterHelper = "3.0.4"
    val espressoCore = "3.3.0"
    val junitExt = "1.1.2"
    val viewpager2 = "1.0.0-beta02"
    val recyclerview = "1.1.0"

    val compileSdkVersion = 30
    val buildToolsVersion = "30.0.2"
    val libMinSdkVersion = 14
    val libTargetSdkVersion = 32
    val libVersionCode = 10104
    val libVersionName = "1.1.5"

    val remote = false

}

object Common{
    val jdk = JavaVersion.VERSION_11
}

object Deps {

    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    object AndroidX{
        val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        val viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.viewmodel}"
        val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
        val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        val espressoCore = "androidx.test.espresso:espresso-core${Versions.espressoCore}"
        val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    }

    object Android{
        val material = "com.google.android.material:material:${Versions.material}"
    }

    val coil = "io.coil-kt:coil:${Versions.coil}"
    val binding = "com.hi-dhl:binding:${Versions.binding}"

    val baseRecyclerViewAdapterHelper = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.baseRecyclerViewAdapterHelper}"
    val junit = "junit:junit:${Versions.junit}"

}
