plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.rodri.custom_pay"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Compose UI
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
}

/**
 * Use this Script for local publish, to test the library
 * Command: ./gradlew publishToMavenLocal
 * */
project.afterEvaluate {
    publishing {
        publications {
            /**
             * Use this for the implementation:
             * implementation("com.payment:custom-pay:1.0.0")
             */
            register<MavenPublication>("release") {
                groupId = "com.payment"
                artifactId = "custom-pay"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
                //artifact("$buildDir/outputs/aar/custom-pay-release.aar")
            }

            /**
             * Use this for the implementation:
             * implementation("com.payment:custom-pay-debug:1.0.0")
             */
            register<MavenPublication>("debug") {
                groupId = "com.payment"
                artifactId = "custom-pay-debug"
                version = "1.0.0"

                afterEvaluate {
                    from(components["debug"])
                }
                //artifact("$buildDir/outputs/aar/custom-pay-debug.aar")
            }
        }
    }
}
