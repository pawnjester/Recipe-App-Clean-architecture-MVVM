import Dependencies.Others
import Dependencies.TestLibraires
import ProjectLib.core

plugins {
    kotlinLibrary
}

dependencies {
    implementation(Others.jodaTime)
    implementation(project(core))

    testImplementation(TestLibraires.junit)
    testImplementation(TestLibraires.truth)
    testImplementation(TestLibraires.coroutinesTest)
}
