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
    val fragment = "1.2.5"
    val koin_version = "2.2.1"
    val nav_version = "2.3.2"
    val constraintlayout = "2.0.4"
    val material = "1.2.1"
    val appcompat = "1.2.0"
    val ktx = "1.3.2"
    val remote = false
    val kotlinVersion = "1.4.21"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.core:core-ktx:${ktx}")
    implementation("androidx.appcompat:appcompat:${appcompat}")
    implementation("com.google.android.material:material:${material}")
    implementation("androidx.constraintlayout:constraintlayout:${constraintlayout}")

    implementation("org.koin:koin-androidx-viewmodel:${koin_version}")
    implementation("io.coil-kt:coil:1.1.0")

    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation("androidx.viewpager2:viewpager2:1.0.0-beta02")

    if (remote) {
        implementation("com.hi-dhl:binding:1.1.3")
    } else {
        implementation(project(":binding"))
    }
    implementation("com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}