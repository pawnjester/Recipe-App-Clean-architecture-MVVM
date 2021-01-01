package com.example.domain.model

data class Recipe (
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val analyzedInstructions : List<Instruction>
)

data class Instruction(
    val name: String,
    val steps: List<Step>
)

data class Step(
    val number: Int,
    val step: String,
    val ingredients: List<Ingredient>
)

data class Ingredient(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
)