package com.example.recipe_view.ui.ui.home

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

class HomeViewModel @ViewModelInject constructor(
    private val getRecipeList: GetRecipeListUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private var _recipes = MutableLiveData<RecipeModel>()
    val recipes: LiveData<RecipeModel> = _recipes

    fun getRecipes(query: String) {
        viewModelScope.launch {
            getRecipeList(query).collect {
                Log.e(">>>", it.data.toString())
            }
        }
    }


}