plugins{
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

buildscript {

    repositories {
        gradlePluginPortal()
        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.5.31"))
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.5.31"))
}

repositories {
    gradlePluginPortal()
    maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { setUrl("https://maven.aliyun.com/repository/public") }
    maven { setUrl("https://maven.aliyun.com/repository/google") }
    google()
    mavenCentral()
}