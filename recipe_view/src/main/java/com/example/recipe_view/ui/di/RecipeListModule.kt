package com.example.recipe_view.ui.di

import com.example.recipe_view.ui.ui.home.RecipesListIntentProcessor
import com.example.recipe_view.ui.ui.home.RecipesListStateMachine
import com.example.recipe_view.ui.ui.home.RecipesListStateReducer
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewIntentProcessor
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewReducer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RecipeListModule {

    @Binds
    abstract fun providesRecipeListReducer(recipeListReducer: RecipeListViewReducer): RecipesListStateReducer

    @Binds
    abstract fun providesRecipeListStateMachine(recipesListStateMachine: RecipesListStateMachine): RecipesListStateMachine

    @Binds
    abstract fun providesRecipeListIntentProcessor(recipeListIntentProcessor: RecipeListViewIntentProcessor): RecipesListIntentProcessor
}