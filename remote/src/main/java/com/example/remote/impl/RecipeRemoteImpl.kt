package com.example.remote.impl

import com.example.data.contracts.remote.RecipeRemote
import com.example.data.model.RecipeEntity
import com.example.remote.ApiService
import com.example.remote.BuildConfig
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
                apiKey = BuildConfig.SPOONACULAR_API_KEY,
                query = query,
                addRecipeInformation = true
            ).results
            if (apiResponse.isNotEmpty()) {
                emit(apiResponse.map {
                    mapper.mapFromModel(it)
                })
            }
        }
    }


}