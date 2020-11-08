package com.example.cache.impl

import com.example.cache.mappers.RecipeCacheModelMapper
import com.example.cache.room.RecipeDao
import com.example.data.contracts.cache.RecipeCache
import com.example.data.model.RecipeEntity
import javax.inject.Inject

class RecipeCacheImpl @Inject constructor(
    private val dao: RecipeDao,
    private val mapper: RecipeCacheModelMapper
) : RecipeCache {

    override suspend fun getRecipes(
        query: String,
        addRecipeInformation: Boolean
    ): List<RecipeEntity> {
        val models = dao.getProducts()
        return mapper.mapToEntityList(models)
    }


}