package com.example.recipe_view.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeModel(
    val id: Int,
    val title: String,
    val summary: String,
    val image: String
) : Parcelable