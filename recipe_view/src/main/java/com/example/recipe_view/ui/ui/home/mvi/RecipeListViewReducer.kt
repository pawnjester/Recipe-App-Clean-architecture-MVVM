package com.example.recipe_view.ui.ui.home.mvi

import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.home.RecipesListStateReducer
import javax.inject.Inject

class RecipeListViewReducer @Inject constructor(
    private val mapper: RecipeModelMapper
) : RecipesListStateReducer {

    override fun reduce(
        previous: RecipeListViewState,
        result: RecipeListViewResult
    ): RecipeListViewState {
        return when (result) {
            RecipeListViewResult.Empty -> RecipeListViewState.Idle
            is RecipeListViewResult.Error -> RecipeListViewState.Error(result.throwable.message ?: "")
            RecipeListViewResult.Idle -> RecipeListViewState.Idle
            RecipeListViewResult.Loading -> RecipeListViewState.Loading
            is RecipeListViewResult.Success -> {
                val recipesList: List<RecipeModel> = mapper.mapToModelList(result.listWithRecipes)
                RecipeListViewState.RecipesListLoaded(recipesList)
            }
        }
    }

}