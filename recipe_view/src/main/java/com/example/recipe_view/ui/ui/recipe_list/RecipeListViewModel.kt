package com.example.recipe_view.ui.ui.recipe_list

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetRecipeListUseCase
import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipeListViewModel @ViewModelInject constructor(
    private val getRecipeList: GetRecipeListUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private val _recipes = MutableLiveData<List<RecipeModel>>()
    val recipes: LiveData<List<RecipeModel>> = _recipes

    fun getRecipes(query: String) {
        viewModelScope.launch {
            getRecipeList(query).collect {
                Log.e(">>>", it.toString())
                val recipes = mapper.mapToModelList(it)
                _recipes.value = recipes
            }
        }
    }
}