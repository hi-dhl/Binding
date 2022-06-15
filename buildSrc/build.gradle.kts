apply{
    plugin("kotlin")
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.4.21"))
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.4.21"))
}

repositories {
    gradlePluginPortal()
}