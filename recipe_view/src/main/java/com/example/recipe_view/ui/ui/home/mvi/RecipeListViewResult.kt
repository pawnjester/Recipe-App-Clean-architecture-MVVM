package com.example.recipe_view.ui.ui.home.mvi

import com.example.domain.model.Recipe
import com.example.presentation.mvi.ViewResult

sealed class RecipeListViewResult : ViewResult {

    object Idle: RecipeListViewResult()
    object Loading: RecipeListViewResult()

    data class Success(val listWithRecipes: List<Recipe>) : RecipeListViewResult()

    object Empty : RecipeListViewResult()
    data class Error(val throwable: Throwable) : RecipeListViewResult()
}