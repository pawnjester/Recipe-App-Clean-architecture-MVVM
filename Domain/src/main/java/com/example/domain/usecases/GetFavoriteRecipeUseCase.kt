package com.example.domain.usecases

import com.example.domain.executor.PostExecutorThread
import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import com.example.domain.usecases.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository,
    private val postExecution: PostExecutorThread
) : FlowUseCase<Nothing, List<Recipe>>() {

    override val dispatcher: CoroutineDispatcher
        get() = postExecution.io

    override fun execute(params: Nothing?): Flow<List<Recipe>> {
        return repository.getFavoriteRecipes()
    }
}