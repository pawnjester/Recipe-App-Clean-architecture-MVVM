package com.example.cache.impl

import com.example.cache.mappers.RecipeCacheModelMapper
import com.example.data.contracts.cache.RecipeCache
import com.example.data.model.RecipeEntity
import javax.inject.Inject

class RecipeCacheImpl @Inject constructor(
    private val mapper: RecipeCacheModelMapper
) : RecipeCache {

    override suspend fun getRecipes(): List<RecipeEntity> {
        TODO("Not yet implemented")
    }
}