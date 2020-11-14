import Dependencies.Others
import ProjectLib.domain
import ProjectLib.testUtils
import ProjectLib.core

plugins {
    kotlinLibrary
}

dependencies {
    implementation(project(domain))
    implementation(project(core))
    implementation(Others.jodaTime)

    testImplementation(project(testUtils))
}