package com.example.domain.repositories

import com.example.domain.executor.Status
import com.example.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipes(query: String) : Flow<Status<List<Recipe>>>

    suspend fun favoriteRecipe(recipe: Recipe)
}