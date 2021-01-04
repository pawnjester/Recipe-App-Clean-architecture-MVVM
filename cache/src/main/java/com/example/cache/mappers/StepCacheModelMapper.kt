package com.example.cache.mappers

import com.example.cache.mappers.base.CacheModelMapper
import com.example.cache.models.StepCacheModel
import com.example.data.model.StepEntity
import javax.inject.Inject

class StepCacheModelMapper @Inject constructor(
    private val mapper: IngredientsCacheModelMapper
) : CacheModelMapper<StepCacheModel, StepEntity> {
    override fun mapToModel(entity: StepEntity): StepCacheModel {
        return entity.run {
            StepCacheModel(
                number,
                step,
                mapper.mapToModelList(ingredients)
            )
        }
    }

    override fun mapToEntity(model: StepCacheModel): StepEntity {
        return model.run {
            StepEntity(
                number ?: 0,
                step ?: "",
                mapper.mapToEntityList(ingredients ?: emptyList())
            )
        }
    }
}