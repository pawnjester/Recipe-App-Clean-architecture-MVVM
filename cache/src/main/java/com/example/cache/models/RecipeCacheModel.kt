package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.models.RecipeCacheModel.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class RecipeCacheModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val summary: String,
    val image: String
) {
    companion object {
        const val TABLE_NAME = "recipe"
    }
}