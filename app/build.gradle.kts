plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.eventyukapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.eventyukapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.database.ktx)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.runtime.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("com.airbnb.android:lottie-compose:6.4.0")

    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha10")

    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Kotlinx Serialization
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //Compose Foundation
    implementation ("androidx.compose.foundation:foundation:1.4.3")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    //Firebase

    implementation(platform("com.google.firebase:firebase-bom:31.1.1"))
    implementation ("com.google.firebase:firebase-auth")
    implementation ("com.google.firebase:firebase-firestore")
    implementation(platform("com.google.firebase:firebase-bom:28.3.0"))
    implementation ("com.google.firebase:firebase-database-ktx")

    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.activity:activity-compose:1.3.1")
    implementation ("androidx.compose.ui:ui:1.0.2")
    implementation ("androidx.compose.material3:material3:1.0.0-alpha12")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.5.21")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")


    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.compose.ui:ui:1.0.5")
    implementation ("androidx.compose.material:material:1.0.5")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.0.5")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.activity:activity-compose:1.4.0")

    // Jetpack Compose dependencies
    implementation ("androidx.compose.ui:ui:1.4.3")
    implementation ("androidx.compose.material3:material3:1.0.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
}

// Allow references to generated code
kapt {
    correctErrorTypes=true
}

apply(plugin = "com.google.gms.google-services")
