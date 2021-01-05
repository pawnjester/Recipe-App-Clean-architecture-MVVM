package com.example.data.contracts.cache

import com.example.data.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

interface RecipeCache {

    fun getFavoriteRecipes(
    ): Flow<List<RecipeEntity>>

    suspend fun favoriteRecipe(recipe: RecipeEntity)

    suspend fun removeRecipe(title: String)
}