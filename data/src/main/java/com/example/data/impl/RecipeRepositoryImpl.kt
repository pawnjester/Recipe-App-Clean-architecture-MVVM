package com.example.data.impl

import com.example.data.contracts.cache.RecipeCache
import com.example.data.mappers.RecipeEntityMapper
import com.example.domain.model.Recipe
import com.example.domain.repositories.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val mapper: RecipeEntityMapper,
    private val recipeRemote: RecipeCache
) : RecipeRepository {

    override fun getRecipe(query: String): Flow<List<Recipe>> {
        return flow {
//            val remoteData = recipeRemote.getRecipes(
//                query = query
//            ).map {
//                mapper.mapFromEntityList(it)
//            }
//            emitAll(remoteData)
        }
    }
}