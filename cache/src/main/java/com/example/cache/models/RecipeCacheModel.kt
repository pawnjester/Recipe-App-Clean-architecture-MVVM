package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cache.models.RecipeCacheModel.Companion.TABLE_NAME
import com.example.cache.room.Converters


@Entity(tableName = TABLE_NAME)
@TypeConverters(Converters::class)
data class RecipeCacheModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val analyzedInstructions: List<InstructionCacheModel>,
    val isFavorite: Boolean = false
) {
    companion object {
        const val TABLE_NAME = "recipe"
    }
}

data class InstructionCacheModel(

    val name: String?,

    val steps: List<StepCacheModel>?
)

data class StepCacheModel(

    val number: Int?,

    val step: String?,

    val ingredients: List<IngredientCacheModel>?
)

data class IngredientCacheModel(

    val id: Int?,

    val name: String?,

    val localizedName: String?,

    val image: String?,
)