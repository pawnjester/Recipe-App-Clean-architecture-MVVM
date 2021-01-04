package com.example.recipe_view.ui.ui.recipe_detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.DeleteRecipeUseCase
import com.example.domain.usecases.FavoriteRecipeUseCase
import com.example.recipe_view.ui.mapper.RecipeModelMapper
import com.example.recipe_view.ui.model.IngredientModel
import com.example.recipe_view.ui.model.InstructionModel
import com.example.recipe_view.ui.model.RecipeModel
import kotlinx.coroutines.launch

class RecipeDetailViewModel @ViewModelInject constructor(
    private val favoriteRecipeUseCase: FavoriteRecipeUseCase,
    private val removeRecipeUseCase: DeleteRecipeUseCase,
    private val mapper: RecipeModelMapper
) : ViewModel() {

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean> = _state

    private var _recipe = MutableLiveData<RecipeModel>()
    var recipe: LiveData<RecipeModel> = _recipe

    private var mainRecipe: RecipeModel? = null

    fun setRecipeDetail(recipe: RecipeModel?) {
        recipe?.let {
            _recipe.value = it
            mainRecipe = it
        }
    }

    fun favoriteRecipe() {

        viewModelScope.launch {
            mainRecipe.let {

                _state.value = !recipe.value!!.isFavorite
                if (mainRecipe!!.isFavorite) {
                    removeRecipeUseCase(_recipe.value?.title ?: "")
                    mainRecipe!!.isFavorite = !mainRecipe!!.isFavorite
                } else {
                    val otherRecipe = mainRecipe?.copy(isFavorite = true)
                    favoriteRecipeUseCase(mapper.mapToDomain(otherRecipe!!))
                    mainRecipe!!.isFavorite = !mainRecipe!!.isFavorite
                }
            }
        }
    }


    fun setFormattedInstructions(recipe: List<InstructionModel>?): String {
        val builder = StringBuilder()
        recipe?.forEach {
            it.steps.forEachIndexed { index, step ->
                builder.append("${step.number}.  ${step.step}")
                builder.append("\n")
            }
        }

        return builder.toString()
    }

    fun setFormattedIngredients(recipe: List<InstructionModel>?): List<IngredientModel> {
        val listOfIngredients = mutableListOf<IngredientModel>()
        recipe?.forEach {
            it.steps.forEach { step ->
                step.ingredients.forEach { ingredients ->
                    listOfIngredients.add(ingredients)
                }
            }
        }
        return listOfIngredients
    }
}