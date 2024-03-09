plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.aya.comestic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aya.comestic"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding=true
        buildConfig = true

    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")
    implementation ("com.intuit.sdp:sdp-android:1.0.6")

    // http & retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.google.code.gson:gson:2.9.0")

    //splash screen
    implementation("androidx.core:core-splashscreen:1.0.0")
    //HILT
    implementation ("com.google.dagger:hilt-android:2.48.1")
    kapt ("com.google.dagger:hilt-compiler:2.48.1")
    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    //GLIDE
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.0")
    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    //To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.6.1")
    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:2.6.1")
    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:2.6.1")
}
