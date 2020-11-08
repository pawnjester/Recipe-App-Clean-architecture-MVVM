package com.example.cache.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cache.BuildConfig
import com.example.cache.models.RecipeCacheModel


@Database(
    entities = [
    RecipeCacheModel::class],
    version = BuildConfig.databaseVersion,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao() : RecipeDao

    companion object {
        private const val DATABASE_NAME = "recipe_db"

        fun build(context: Context): RecipeDatabase = Room.databaseBuilder(
            context.applicationContext,
            RecipeDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}