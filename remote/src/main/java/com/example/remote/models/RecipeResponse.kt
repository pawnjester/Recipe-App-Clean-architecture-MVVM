package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

    @SerializedName("results")
    val results: List<RecipeNetworkModel>
)