plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.example.newsinshort"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newsinshort"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
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
//    implementation(libs.androidx.navigation.compose.jvmstubs)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt
    implementation(libs.hilt.android)
    // KSP for Hilt (if using KSP)
    ksp(libs.hilt.compiler)
    // Navigation Compose
    implementation(libs.androidx.navigation.compose)
    // Hilt Navigation Compose Integration
    implementation(libs.androidx.hilt.navigation.compose)
    // Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)  // Include if you plan to use Gson with Retrofit
    implementation(libs.retrofit.converter.moshi) // Include if you plan to use Moshi with Retrofit
    // OkHttp (logging interceptor)
    implementation(libs.okhttp.logging.interceptor)
    // implementation(libs.okhttp.core) // Retrofit includes OkHttp, so this is optional unless you need a specific version or use OkHttp directly
    // Gson (if used standalone or with Retrofit)
    implementation(libs.gson)
    // Moshi (if used standalone or with Retrofit)
    implementation(libs.moshi.core)
    implementation(libs.moshi.kotlin) // For Kotlin support (reflection or codegen)
    ksp(libs.moshi.kotlin.codegen)
    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

}
