package com.example.recipe_view.ui.ui.recipe_list

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetRecipeListUseCase
import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RecipeListViewModel @ViewModelInject constructor(
    private val getRecipeList: GetRecipeListUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private var _recipes = MutableLiveData<RecipeModel>()
    val recipes: LiveData<RecipeModel> = _recipes

    fun getRecipes(query: String) {
        viewModelScope.launch {
            try {
                getRecipeList(query).map { recipes ->
                    Log.e("DDD", recipes.toString())
                }
            } catch (e: NetworkErrorException) {
                Log.e("TTT", e.message ?: "errr")
            }
        }

    }


}