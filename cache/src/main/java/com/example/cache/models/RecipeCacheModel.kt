package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe")
data class RecipeCacheModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val summary: String,
    val image: String
)