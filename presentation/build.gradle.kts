import Dependencies.TestLibraires

plugins {
    kotlinLibrary
}

dependencies {
    testImplementation(TestLibraires.junit)
    testImplementation(TestLibraires.truth)
}