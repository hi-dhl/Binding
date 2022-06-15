import com.hi.dhl.*
import com.hi.dhl.Versions.remote

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.hi.dhl.demo.binding"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(true)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(Deps.kotlinStdlib)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.Android.material)
    implementation(Deps.AndroidX.constraintlayout)

    implementation(Deps.AndroidX.viewmodel)
    implementation(Deps.coil)

    implementation(Deps.AndroidX.navigationFragmentKtx)
    implementation(Deps.AndroidX.navigationUiKtx)

    implementation(Deps.AndroidX.viewpager2)

    if (remote) {
        implementation(Deps.binding)
    } else {
        implementation(project(":binding"))
    }
    implementation(Deps.baseRecyclerViewAdapterHelper)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.AndroidX.junitExt)
    androidTestImplementation(Deps.AndroidX.espressoCore)
}