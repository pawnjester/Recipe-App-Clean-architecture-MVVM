package com.example.domain.usecases

import com.example.domain.executor.PostExecutorThread
import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository,
    private val postExecution: PostExecutorThread
) {

    suspend operator fun invoke(recipe: Recipe) {
        withContext(postExecution.io) {
            repository.favoriteRecipe(recipe)
        }
    }


}