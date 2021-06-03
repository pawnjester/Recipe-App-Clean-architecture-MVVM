package com.example.recipe_view.ui.ui.home.mvi

import com.example.presentation.mvi.ViewState
import com.example.recipe_view.ui.model.RecipeModel

sealed class RecipeListViewState: ViewState {

    object Idle: RecipeListViewState()
    object Loading: RecipeListViewState()
    data class RecipesListLoaded(val listWithRecipes: List<RecipeModel>) : RecipeListViewState()
    data class Error(val message: String) : RecipeListViewState()
}