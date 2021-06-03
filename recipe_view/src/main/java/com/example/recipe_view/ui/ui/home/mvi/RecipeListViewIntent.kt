package com.example.recipe_view.ui.ui.home.mvi

import com.example.presentation.mvi.ViewIntent

sealed class RecipeListViewIntent : ViewIntent {

    object Idle : RecipeListViewIntent()
    data class LoadRecipesLists(val query: String): RecipeListViewIntent()
}