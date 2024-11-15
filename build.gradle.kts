import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform) 
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.rootDir.path)
                    }
                }
                cssSupport { enabled.set(true) }
            }
        }
    }

    sourceSets {
      val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            }
        }
        val wasmJsMain by getting
        val wasmJsTest by getting
    }
}
