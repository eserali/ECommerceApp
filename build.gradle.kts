// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false

    id ("com.google.dagger.hilt.android") version "2.48.1" apply false
    id ("com.google.devtools.ksp") version ("1.9.10-1.0.13") apply false

}
buildscript {
    repositories {
        google()

    }
    dependencies {
        val nav_version = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
    }
}