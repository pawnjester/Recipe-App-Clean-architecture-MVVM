package com.example.recipe_view.ui.ui.home.mvi

import com.example.recipe_view.ui.ui.home.RecipesListStateReducer
import javax.inject.Inject

class RecipeListViewStateMachine  @Inject constructor(
    intentProcessor: RecipeListViewIntentProcessor,
    reducer: RecipesListStateReducer
) {
}