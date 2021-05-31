package com.example.recipe_view.ui.ui.recipe_favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetFavoriteRecipeUseCase
import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.home.LatestNewsUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavoriteRecipeViewModel @ViewModelInject constructor(
    private val getFavoriteList: GetFavoriteRecipeUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private val _favoriteRecipes = MutableLiveData<LatestNewsUiState<List<RecipeModel>>>()
    val favoriteRecipes: LiveData<LatestNewsUiState<List<RecipeModel>>> = _favoriteRecipes

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            getFavoriteList().map {
                mapper.mapToModelList(it)
            }
                .collect {
                _favoriteRecipes.value = LatestNewsUiState.Success(it)
            }
        }
    }
}