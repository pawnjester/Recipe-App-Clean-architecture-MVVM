package com.example.cache.mappers

import com.example.cache.mappers.base.CacheModelMapper
import com.example.cache.models.IngredientCacheModel
import com.example.data.model.IngredientEntity
import javax.inject.Inject

class IngredientsCacheModelMapper @Inject constructor() :
    CacheModelMapper<IngredientCacheModel, IngredientEntity> {
    override fun mapToModel(entity: IngredientEntity): IngredientCacheModel {
        return entity.run {
            IngredientCacheModel(
                id,
                name,
                localizedName, image
            )
        }
    }

    override fun mapToEntity(model: IngredientCacheModel): IngredientEntity {
        return model.run {
            IngredientEntity(
                id ?: 0,
                name ?: "",
                localizedName ?: "", image ?: ""
            )
        }
    }
}