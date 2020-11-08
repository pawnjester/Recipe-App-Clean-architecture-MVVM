package com.example.data.contracts.cache

import com.example.data.model.RecipeEntity

interface RecipeCache {

    suspend fun getRecipes(
        query: String,
        addRecipeInformation: Boolean
    ) : List<RecipeEntity>
}