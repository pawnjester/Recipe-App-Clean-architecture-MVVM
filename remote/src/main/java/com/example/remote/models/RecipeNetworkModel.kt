package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class RecipeNetworkModel(
    val id: Int,
    @SerializedName("title")
    val title: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("image")
    val image: String
)