package com.example.data.contracts.cache

import com.example.data.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

interface RecipeCache {

    fun getRecipes(
        query: String,
        addRecipeInformation: Boolean
    ) : Flow<List<RecipeEntity>>

    suspend fun favoriteRecipe(recipe: RecipeEntity)

}