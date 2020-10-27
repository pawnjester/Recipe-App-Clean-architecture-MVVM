import Dependencies.TestLibraires
import ProjectLib.domain

plugins {
    kotlinLibrary
}

dependencies {
    implementation(project(domain))
    api(TestLibraires.junit)
    api(TestLibraires.truth)
    api(TestLibraires.coroutinesTest)
}
