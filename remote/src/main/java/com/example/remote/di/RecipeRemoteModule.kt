package com.example.remote.di

import com.example.data.contracts.remote.RecipeRemote
import com.example.remote.impl.RecipeRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RecipeRemoteModule {

    @Binds
    abstract fun providesRecipeRemote(impl: RecipeRemoteImpl): RecipeRemote
}