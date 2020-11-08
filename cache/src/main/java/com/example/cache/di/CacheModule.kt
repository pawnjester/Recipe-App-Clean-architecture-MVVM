package com.example.cache.di

import android.content.Context
import com.example.cache.room.RecipeDao
import com.example.cache.room.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {


    @[Provides Singleton]
    fun providesDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return RecipeDatabase.build(context)
    }

    @[Provides Singleton]
    fun providesRecipeDao(database: RecipeDatabase): RecipeDao {
        return database.recipeDao()
    }
}