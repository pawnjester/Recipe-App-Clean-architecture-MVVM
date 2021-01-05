package com.example.cache.impl

import com.example.cache.mappers.RecipeCacheModelMapper
import com.example.cache.room.RecipeDao
import com.example.data.contracts.cache.RecipeCache
import com.example.data.model.RecipeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeCacheImpl @Inject constructor(
    private val dao: RecipeDao,
    private val mapper: RecipeCacheModelMapper
) : RecipeCache {

    override fun getFavoriteRecipes(
    ): Flow<List<RecipeEntity>> {
        return flow {
            val models = dao.getProducts()
            emit(models.map {
                mapper.mapToEntity(it)
            })

        }
    }

    override suspend fun favoriteRecipe(recipe: RecipeEntity) {
        dao.favoriteRecipe(mapper.mapToModel(recipe))
    }

    override suspend fun removeRecipe(title: String) {
        dao.removeRecipe(title)
    }

}