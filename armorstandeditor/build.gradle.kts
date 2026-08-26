plugins {
    java
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.21"
    id("com.gradleup.shadow") version "9.2.2"
}

group = "me.asfor"
version = "1.1"

dependencies {
    paperweight.paperDevBundle("26.2.build.+")

    implementation("net.wesjd:anvilgui:1.10.13-SNAPSHOT")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.shadowJar {
    relocate("net.wesjd.anvilgui", "me.asfor.libs.anvilgui")

    doLast {
        copy {
            from(archiveFile)
            into("C:/Users/01254/Desktop/Minecraft/Server/plugins")
        }
    }
}