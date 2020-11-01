package com.example.data.impl

import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(

) : RecipeRepository {

    override fun searchRecipe(): Flow<Recipe> {
        TODO("Not yet implemented")
    }
}