package com.example.data.contracts.cache

import com.example.data.model.RecipeEntity

interface RecipeCache {

    suspend fun getRecipes() : List<RecipeEntity>
}