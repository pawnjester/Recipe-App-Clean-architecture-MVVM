package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class RecipeNetworkModel(
    val id: Int,
    @SerializedName("title")
    val title: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("analyzedInstructions")
    val analyzedInstructions : List<InstructionNetworkModel>
)

data class InstructionNetworkModel(
    val name: String,
    val steps: List<StepNetworkModel>
)

data class StepNetworkModel(
    val number: Int,
    val step: String,
    val ingredients: List<IngredientNetworkModel>
)

data class IngredientNetworkModel(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
)