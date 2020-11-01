package com.example.data.contracts.remote

import com.example.data.model.RecipeEntity

interface RecipeRemote {

    suspend fun getRecipes() : List<RecipeEntity>
}