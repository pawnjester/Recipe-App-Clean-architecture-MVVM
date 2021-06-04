package com.example.recipe_view.ui.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.mvi.MVIPresenter
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewIntent
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn

class HomeViewModel @ViewModelInject constructor(
    private val recipesListStateMachine: RecipesListStateMachine
) : ViewModel(), MVIPresenter<RecipeListViewState, RecipeListViewIntent> {

    init {
        recipesListStateMachine.processor.launchIn(viewModelScope)
    }

    override val viewState: Flow<RecipeListViewState>
        get() = recipesListStateMachine.viewState

    override fun processIntent(intents: Flow<RecipeListViewIntent>) {
        recipesListStateMachine.processIntents(intents)
            .launchIn(viewModelScope)
    }
}