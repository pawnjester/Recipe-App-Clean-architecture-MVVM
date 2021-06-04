package com.example.recipe_view.ui.di

import com.example.recipe_view.ui.ui.home.RecipesListStateMachine
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewStateMachine
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
interface RecipeListStateMachineModule {

    @get:Binds
    val RecipeListViewStateMachine.stateMachine: RecipesListStateMachine
}