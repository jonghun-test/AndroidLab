plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.ch20_firebase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ch20_firebase"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true
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

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 20
    implementation(platform(libs.firebase.bom))
    implementation(libs.play.services.auth)
    implementation(libs.androidx.multidex)
    implementation(libs.firebase.auth.ktx)

    //21
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.glide)
    implementation(libs.firebase.ui.storage)
    implementation(libs.compiler)

    //21-5
    implementation(libs.firebase.messaging.ktx)
    implementation(libs.firebase.analytics.ktx)
}