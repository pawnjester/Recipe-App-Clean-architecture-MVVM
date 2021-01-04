package com.example.domain.usecases

import com.example.domain.executor.PostExecutorThread
import com.example.domain.repositories.RecipeRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository,
    private val postExecution: PostExecutorThread
) {

    suspend operator fun invoke(name: String) {
        withContext(postExecution.io) {
            repository.removeRecipe(name)
        }
    }
}