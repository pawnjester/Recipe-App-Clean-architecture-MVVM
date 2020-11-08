package com.example.data.impl

import com.example.data.contracts.cache.RecipeCache
import com.example.data.contracts.remote.RecipeRemote
import com.example.data.mappers.RecipeEntityMapper
import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mapper: RecipeEntityMapper,
    private val recipeCache: RecipeCache,
    private val recipeRemote: RecipeRemote
) : RecipeRepository {

    override fun getRecipe(query: String): Flow<List<Recipe>> {
        return flow {
            val recipeCache = recipeCache.getRecipes("", true)
            val remoteData = recipeRemote.getRecipes(
                query = query
            ).map {
                mapper.mapFromEntityList(it)
            }
            emitAll(remoteData)
        }
    }
}