import com.hi.dhl.*

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
//    val kotlinVersion = "1.4.21"
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath(kotlin("gradle-plugin", "1.4.21"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        google()
        mavenCentral()
    }

//    tasks.withType(Javadoc).all { enabled = false }
    tasks.withType<Javadoc>().all{
        enabled = false
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}