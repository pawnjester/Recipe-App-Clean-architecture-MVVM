package com.example.remote

import com.example.remote.models.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true
    ): RecipeResponse
}