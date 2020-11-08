package com.example.recipe_view.ui.mapper

import com.example.domain.model.Recipe
import com.example.recipe_view.ui.mapper.base.ModelMapper
import com.example.recipe_view.ui.model.RecipeModel
import javax.inject.Inject

class RecipeModelMapper @Inject constructor(): ModelMapper<RecipeModel, Recipe> {

    override fun mapToModel(domain: Recipe): RecipeModel {
        return domain.run {
            RecipeModel(
                domain.id,
                domain.title,
                domain.summary,
                domain.image
            )
        }
    }

    override fun mapToDomain(model: RecipeModel): Recipe {
        return model.run {
            Recipe(
                model.id,
                model.title,
                model.summary,
                model.image
            )
        }
    }
}