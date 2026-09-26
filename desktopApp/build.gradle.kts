import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)


}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }

}
compose.desktop {
    application {
        mainClass = "com.desktopapp.WindowsMainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Exe, TargetFormat.Msi)

            packageName = "CodexVanguard"
            packageVersion = "1.2.0"
            description = "Codex Vanguard"
            vendor = "SantanuSarkar"

            windows {
                menuGroup = "Codex Vanguard"
                upgradeUuid = "16783672-7651-4627-b091-56670e876767"
                iconFile.set(project.file("src/main/resources/icon.ico"))
                perUserInstall = true
                shortcut = true
                menu = true
                includeAllModules = true
            }

            buildTypes.release.proguard {
                isEnabled.set(true)
                optimize.set(true)
                obfuscate.set(true)
                configurationFiles.from(project.file("compose-desktop.pro"))
            }
        }
    }
}
dependencies {


    implementation(libs.androidx.lifecycle.viewmodel.desktop)
    implementation(kotlin("stdlib"))
    implementation(project(":sensoryUnit"))
    implementation(compose.desktop.currentOs)
    implementation(project(":shared"))
    implementation(project(":sharedUI"))
    implementation(project(":Domain"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.swing)
}
