package com.example.cache.di

import com.example.cache.impl.RecipeCacheImpl
import com.example.data.contracts.cache.RecipeCache
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RecipeCacheModule {

    @Binds
    abstract fun providesRecipeCache(recipeCacheImpl: RecipeCacheImpl): RecipeCache
}