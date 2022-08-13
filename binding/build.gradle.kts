import com.hi.dhl.*

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Versions.compileSdkVersion
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        minSdk = Versions.libMinSdkVersion
        targetSdk = Versions.libTargetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(Deps.AndroidX.recyclerview)
}

//apply{
//        from("${rootDir}/gradle-mvn-push.gradle")
//}
