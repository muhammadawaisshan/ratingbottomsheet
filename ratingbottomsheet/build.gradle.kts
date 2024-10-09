plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.muhammadawaisshan"
            artifactId = "ratingbottomsheet"
            version = "1.0.4"

            // Optional: Add POM metadata
            pom {
                name.set("RatingBottomSheet")
                description.set("A custom rating bottom sheet for Android.")
                url.set("https://github.com/muhammadawaisshan/ratingbottomsheet")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("muhammadawaisshan")
                        name.set("Muhammad Awais Shan")
                        email.set("muhammadawaisshan@gmail.com")
                    }
                }
            }
        }
    }
}
android {
    namespace = "com.iobits.tech.ratingbottomsheet"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"

            )
        }
    }
    viewBinding {
        enable = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":ratingbottomsheet:ratingbar"))
    implementation(libs.sdp.android)

}