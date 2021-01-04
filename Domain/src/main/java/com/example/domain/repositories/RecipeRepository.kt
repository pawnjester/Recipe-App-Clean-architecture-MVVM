package com.example.domain.repositories

import com.example.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipes(query: String): Flow<List<Recipe>>

    suspend fun favoriteRecipe(recipe: Recipe)

    fun getFavoriteRecipes() : Flow<List<Recipe>>

    suspend fun removeRecipe(title: String)
}