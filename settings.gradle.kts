pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://artifactory.skoda.vwgroup.com/artifactory/gra-maul-gradle-public/")
        }
    }
}


rootProject.name = "MySkodaAppFeature"
include(":app")
