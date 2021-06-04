package com.example.recipe_view.ui.navigation

import com.example.recipe_view.ui.model.RecipeModel

interface NavigationDispatcher {
    fun openRecipeListDetail(model: RecipeModel)
}