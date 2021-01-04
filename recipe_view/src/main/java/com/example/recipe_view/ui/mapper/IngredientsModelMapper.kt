package com.example.recipe_view.ui.mapper

import com.example.domain.model.Ingredient
import com.example.recipe_view.ui.mapper.base.ModelMapper
import com.example.recipe_view.ui.model.IngredientModel
import javax.inject.Inject

class IngredientsModelMapper @Inject constructor(

) : ModelMapper<Ingredient, IngredientModel> {

    override fun mapToModel(domain: IngredientModel): Ingredient {
        return domain.run {
            Ingredient(
                id, name, localizedName, image
            )
        }
    }

    override fun mapToDomain(model: Ingredient): IngredientModel {
        return model.run {
            IngredientModel(
                id, name, localizedName, image
            )
        }
    }
}