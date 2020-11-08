package com.example.core.di

import com.example.data.impl.RecipeRepositoryImpl
import com.example.domain.repositories.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun providesRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl) : RecipeRepository

}