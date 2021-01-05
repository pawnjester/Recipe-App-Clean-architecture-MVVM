package com.example.remote.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.IngredientEntity
import com.example.remote.models.IngredientNetworkModel
import javax.inject.Inject

class IngredientsNetworkMapper @Inject constructor(

) : EntityMapper<IngredientEntity, IngredientNetworkModel> {

    override fun mapFromEntity(entity: IngredientEntity): IngredientNetworkModel {
        return entity.run {
            IngredientNetworkModel(
                id, name, localizedName, image
            )
        }
    }

    override fun mapToEntity(domain: IngredientNetworkModel): IngredientEntity {
        return domain.run {
            IngredientEntity(
                id, name, localizedName, image
            )
        }
    }
}