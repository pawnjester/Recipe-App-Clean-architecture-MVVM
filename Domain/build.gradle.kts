import Dependencies.Others
import Dependencies.TestLibraires

plugins {
    kotlinLibrary
}

dependencies {
    implementation(Others.jodaTime)
    testImplementation(TestLibraires.junit)
    testImplementation(TestLibraires.truth)
    testImplementation(TestLibraires.coroutinesTest)
}
