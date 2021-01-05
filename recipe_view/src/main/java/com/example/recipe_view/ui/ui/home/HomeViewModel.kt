package com.example.recipe_view.ui.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetRecipeListUseCase
import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getRecipeList: GetRecipeListUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private val _recipes = MutableLiveData<LatestNewsUiState<List<RecipeModel>>>()
    val recipes: LiveData<LatestNewsUiState<List<RecipeModel>>> = _recipes

    fun getRecipes(query: String) {
        _recipes.value =
            LatestNewsUiState.Loading
        viewModelScope.launch {
            getRecipeList(query).map {
                mapper.mapToModelList(it)
            }.debounce(2000)
                .catch {
                    _recipes.value =
                        LatestNewsUiState.Error(
                            it.message ?: ""
                        )
                }.collect {
                    _recipes.value =
                        LatestNewsUiState.Success(
                            it
                        )
                }
        }
    }
}

sealed class LatestNewsUiState<out T : Any> {
    data class Success<out T : Any>(val recipes: T) : LatestNewsUiState<T>()
    object Loading : LatestNewsUiState<Nothing>()
    data class Error(val exception: String) : LatestNewsUiState<Nothing>()
}