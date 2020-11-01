package com.example.remote.impl

import com.example.data.contracts.remote.RecipeRemote
import com.example.data.model.RecipeEntity
import com.example.remote.models.RecipeNetworkModel
import javax.inject.Inject

class RecipeRemoteImpl @Inject constructor(
    private val mapper: RecipeNetworkModel
) : RecipeRemote {


    override suspend fun getRecipes(): List<RecipeEntity> {
        TODO("Not yet implemented")
    }
}