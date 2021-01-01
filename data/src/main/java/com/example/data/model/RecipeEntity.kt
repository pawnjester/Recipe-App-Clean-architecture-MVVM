package com.example.data.model

data class RecipeEntity(
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val analyzedInstructions: List<InstructionEntity>
)

data class InstructionEntity(
    val name: String,
    val steps: List<StepEntity>
)

data class StepEntity(
    val number: Int,
    val step: String,
    val ingredients: List<IngredientEntity>
)

data class IngredientEntity(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
)