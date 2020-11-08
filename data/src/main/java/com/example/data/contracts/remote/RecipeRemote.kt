package com.example.data.contracts.remote

import com.example.data.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

interface RecipeRemote {

    fun getRecipes(
        query: String,
        addRecipeInformation: Boolean? = true
    ) : Flow<List<RecipeEntity>>
}