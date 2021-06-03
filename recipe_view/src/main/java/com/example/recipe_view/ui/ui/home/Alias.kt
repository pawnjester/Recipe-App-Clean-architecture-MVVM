package com.example.recipe_view.ui.ui.home

import com.example.presentation.mvi.IntentProcessor
import com.example.presentation.mvi.StateMachine
import com.example.presentation.mvi.ViewStateReducer
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewIntent
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewResult
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewState

typealias RecipesListIntentProcessor =
        @JvmSuppressWildcards IntentProcessor<RecipeListViewIntent, RecipeListViewResult>

typealias RecipesListStateReducer =
        @JvmSuppressWildcards ViewStateReducer<RecipeListViewState, RecipeListViewResult>

typealias RecipesListStateMachine =
        @JvmSuppressWildcards StateMachine<RecipeListViewIntent, RecipeListViewState, RecipeListViewResult>