pluginManagement {
    repositories {
        google()
        mavenCentral()
        // JitPack – нужен, чтобы стянуть usb‑serial‑for‑android
        maven(url = "https://jitpack.io")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "KM5Mobile"
include(":app")
