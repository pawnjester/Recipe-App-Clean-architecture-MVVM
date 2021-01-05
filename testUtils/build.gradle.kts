import Dependencies.TestLibraires

plugins {
    kotlinLibrary
}

dependencies {
    api(TestLibraires.junit)
    api(TestLibraires.truth)
    api(TestLibraires.coroutinesTest)
}
