apply{
    plugin("kotlin")
}

buildscript {

    repositories {
        gradlePluginPortal()
//        mavenLocal()
//        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
//        maven { setUrl("https://maven.aliyun.com/repository/public") }
//        maven { setUrl("https://maven.aliyun.com/repository/google") }
//        google()
//        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.6.10"))
    }
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.6.10"))
}

repositories {
    gradlePluginPortal()
}