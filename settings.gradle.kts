rootProject.name = "Recipe Application"
include(
    ":app",
    ":domain",
    ":core",
    ":cache",
    ":data",
    ":recipe_view",
    ":testUtils",
    ":remote"
)
include(":presentation")
