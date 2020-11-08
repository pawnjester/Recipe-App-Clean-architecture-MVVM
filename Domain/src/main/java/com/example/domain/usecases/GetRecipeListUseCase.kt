package com.example.domain.usecases

import com.example.domain.executor.PostExecutorThread
import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import com.example.domain.usecases.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipeListUseCase @Inject constructor(
    private val repository: RecipeRepository,
    private val postExecution: PostExecutorThread
): FlowUseCase<String, List<Recipe>>()  {

    override val dispatcher: CoroutineDispatcher
        get() = postExecution.io

    override fun execute(params: String?): Flow<List<Recipe>> {
        requireNotNull(params) {"params cannot be null"}
        return repository.getRecipe(params)
    }

}