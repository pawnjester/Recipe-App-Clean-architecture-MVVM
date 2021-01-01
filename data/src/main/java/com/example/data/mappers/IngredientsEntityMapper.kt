package com.example.data.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.IngredientEntity
import com.example.domain.model.Ingredient
import javax.inject.Inject

class IngredientsEntityMapper @Inject constructor(

) : EntityMapper<IngredientEntity, Ingredient> {

    override fun mapFromEntity(entity: IngredientEntity): Ingredient {
        return entity.run {
            Ingredient(
                id, name, localizedName, image
            )
        }
    }

    override fun mapToEntity(domain: Ingredient): IngredientEntity {
        return domain.run {
            IngredientEntity(
                id, name, localizedName, image
            )
        }
    }
}