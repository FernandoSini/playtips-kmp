import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
   // tasks.create("testClasses")
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {

            //binaryOption("bundleId", "br.com.playtips")
            binaryOption("bundleId", "br.com.playtips.ComposeApp")
            binaryOption("bundleVersion", "1")
            binaryOption("bundleShortVersionString", "1.0.0")
            //binaryOption("bundleName",  "pppp")
            // binaryOption("PRODUCT_NAME",  "playtips")
            // binaryOption("bundleName", "teste")

            /*
                 investigar porque isso nao está funcionando
                 binaryOptions["bundleName"] = "ppppp"
                  binaryOptions["bundleId"] = "br.com.playtips.shared"
                  binaryOptions["bundleShortVersionString"] = "1.0.0"
                  binaryOptions["bundleVersion"] = "4"
                  binaryOptions.forEach { (option, value) ->
                      linkerOpts.add("-Xbinary=$option=$value")
                      linkerOpts.add("-Xconfig=$option=$value")

                  }*/
            baseName = "ComposeApp"
            isStatic = true
            // linkerOpts.add("-lsqlite3")

            //linkerOpts.add("-Xbinary=$option=$value")
        }
    }


    sourceSets {

        androidMain.dependencies {

            implementation(libs.ktor.client.android)
            implementation(compose.uiTooling)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.activity.ktx)
            //   implementation(libs.androidx.activity.ktx)
            //       implementation("dev.icerock.moko:permissions-compose:0.18.0")

            /*
           veio padrao
           implementation(compose.preview)
            implementation(libs.androidx.activity.compose)*/
        }
        commonMain.dependencies {

            implementation("com.ionspin.kotlin:bignum:0.3.9")
            implementation("io.github.thechance101:chart:Beta-0.0.5")
            implementation("io.github.kevinnzou:compose-webview-multiplatform:1.9.40")
            // implementation("org.jetbrains.androidx.lifecycle:lifecycle-*:2.8.3")
            //implementation("org.jetbrains.compose.material3.adaptive:adaptive-*:1.0.0")
            //api(libs.permissions.compose)
            implementation(libs.permissions.compose)
            // implementation("dev.icerock.moko:permissions-compose:0.18.0")
            // implementation("org.jetbrains.compose.material3.adaptive:adaptive:1.0.1")
            implementation(libs.jetbrains.adaptive)

            implementation(libs.adaptive.layout)
            //  implementation("org.jetbrains.compose.material3.adaptive:adaptive-layout:1.0.0-alpha03")

            // implementation("org.jetbrains.compose.material3.adaptive:adaptive-navigation:1.0.0-alpha03")
            implementation(libs.jetbrains.adaptive.navigation)
            //implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
            implementation(libs.jetbrains.lifecycle.viewmodel.compose)
            implementation(libs.navigation.compose)
            //implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")
            implementation("org.jetbrains.compose.material:material-navigation:1.7.0-beta02")
            //implementation(libs.material.navigation)
            //implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")
            //implementation("io.coil-kt.coil3:coil-network-ktor:3.0.0-alpha06")
            //implementation("io.coil-kt.coil3:coil-compose:3.0.4")
            implementation(libs.coil3.coil.compose)
            // implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.4")
            implementation(libs.coil3.coil.network.ktor3)
            //implementation("org.jetbrains.compose.material3:material3-window-size-class:1.7.1")
            implementation("org.jetbrains.compose.material3:material3-window-size-class:1.7.1")
            //implementation("org.jetbrains.compose.material3:material3-window-size-class:1.7.1")
            implementation(libs.coil.svg)
            //implementation("io.coil-kt.coil3:coil-svg:3.0.0-alpha06")
            //implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.3.3")
            //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
            //implementation("com.russhwolf:multiplatform-settings-no-arg:1.1.1")
            implementation(libs.russhwolf.multiplatform.settings.no.arg)
            //implementation("io.ktor:ktor-client-core:3.0.1")
            // implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
            //implementation("org.jetbrains.androidx.navigation:navigation-*:2.8.0-alpha10")
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.kotlinx.datetime)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3AdaptiveNavigationSuite)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            //   @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            //implementation("androidx.compose.material3:material3-*:1.4.0-alpha04")
            // implementation(libs.compose)
            // implementation(libs.android.adaptive)
            // implementation(libs.android.navigation)
            //implementation(libs.androidx.lifecycle)
            /*
           //o que veio padrao
           implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)*/
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        iosX64Main.dependencies {
            implementation(libs.ktor.client.darwin)

        }
        iosArm64Main.dependencies {
            implementation(libs.ktor.client.darwin)

        }
        iosSimulatorArm64Main.dependencies {
            implementation(libs.ktor.client.darwin)


        }
        iosMain.dependencies {
            // implementation("dev.icerock.moko:permissions-compose:0.18.0")
            implementation(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)

        }
    }
}
    android {
        namespace = "br.com.playtips"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
        sourceSets["main"].res.srcDirs("src/androidMain/res")
        sourceSets["main"].resources.srcDirs("src/commonMain/resources")

        defaultConfig {
            applicationId = "br.com.playtips"
            minSdk = libs.versions.android.minSdk.get().toInt()
            targetSdk = libs.versions.android.targetSdk.get().toInt()
            versionCode = 1
            versionName = "1.0"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }


/*dependencies {
    debugImplementation(compose.uiTooling)
}*/

