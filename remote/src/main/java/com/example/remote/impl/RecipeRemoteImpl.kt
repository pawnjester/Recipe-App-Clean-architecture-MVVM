package com.example.remote.impl

import com.example.data.contracts.remote.RecipeRemote
import com.example.data.model.RecipeEntity
import com.example.remote.ApiService
import com.example.remote.mappers.RecipeNetworkModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRemoteImpl @Inject constructor(
    private val mapper: RecipeNetworkModelMapper,
    private val apiService: ApiService
) : RecipeRemote {

    override fun getRecipes(
        query: String,
        addRecipeInformation: Boolean?
    ): Flow<List<RecipeEntity>> {
        return flow {
            val apiResponse = apiService.getRecipes(
                apiKey = "af8e56d167184bafaa69b19b603f276d",
                query = query,
                addRecipeInformation = true
            ).results.map {
                mapper.mapFromModel(it)
            }
            emit(apiResponse)
        }
    }


}