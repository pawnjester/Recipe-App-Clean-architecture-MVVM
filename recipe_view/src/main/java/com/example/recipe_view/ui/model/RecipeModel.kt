package com.example.recipe_view.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeModel(
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val analyzedInstructions: List<InstructionModel>,
    var isFavorite: Boolean = false
) : Parcelable

@Parcelize
data class InstructionModel(
    val name: String,
    val steps: List<StepModel>
): Parcelable

@Parcelize
data class StepModel(
    val number: Int,
    val step: String,
    val ingredients: List<IngredientModel>
): Parcelable

@Parcelize
data class IngredientModel(
    val id: Int,
    val name: String,
    val localizedName: String,
    val image: String,
): Parcelable