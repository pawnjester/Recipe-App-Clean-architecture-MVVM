package com.example.recipe_view.ui.ui.home.mvi

import com.example.domain.model.Recipe
import com.example.domain.usecases.GetRecipeListUseCase
import com.example.recipe_view.ui.ui.home.RecipesListIntentProcessor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipeListViewIntentProcessor @Inject constructor(
    private val getRecipes: GetRecipeListUseCase
) : RecipesListIntentProcessor {

    override fun intentToResult(viewIntent: RecipeListViewIntent): Flow<RecipeListViewResult> {
        return when (viewIntent) {
            RecipeListViewIntent.Idle -> flowOf(RecipeListViewResult.Idle)
            is RecipeListViewIntent.LoadRecipesLists -> loadRecipesLists(viewIntent.query)
        }
    }

    private fun loadRecipesLists(query: String): Flow<RecipeListViewResult> {
        return getRecipes(query)
            .map { recipesList: List<Recipe> ->
                if (recipesList.isEmpty()) {
                    RecipeListViewResult.Empty
                } else {
                    RecipeListViewResult.Success(recipesList)
                }
            }.catch { error: Throwable ->
                emit(RecipeListViewResult.Error(error))
            }
    }
}