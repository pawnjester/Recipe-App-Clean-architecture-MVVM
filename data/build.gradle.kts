import Dependencies.Others
import ProjectLib.domain
import ProjectLib.testUtils

plugins {
    kotlinLibrary
}

dependencies {
    implementation(project(domain))
    implementation(Others.jodaTime)

    testImplementation(project(testUtils))
}