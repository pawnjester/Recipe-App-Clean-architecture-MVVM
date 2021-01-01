package com.example.recipe_view.ui.ui.recipe_detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.recipe_view.ui.model.IngredientModel
import com.example.recipe_view.ui.model.InstructionModel

class RecipeDetailViewModel @ViewModelInject constructor(

) : ViewModel() {


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