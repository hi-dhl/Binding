import com.hi.dhl.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Versions.compileSdkVersion
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = "com.hi.dhl.demo.binding"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = Common.jdk
        targetCompatibility = Common.jdk
    }

    kotlinOptions {
        jvmTarget = Common.jdk.toString()
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

    if (Versions.remote) {
        implementation(Deps.binding)
    } else {
        implementation(project(":binding"))
    }
    implementation(Deps.baseRecyclerViewAdapterHelper)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.AndroidX.junitExt)
    androidTestImplementation(Deps.AndroidX.espressoCore)
}