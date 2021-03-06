package com.example.cache.mappers

import com.example.cache.mappers.base.CacheModelMapper
import com.example.cache.models.RecipeCacheModel
import com.example.data.model.RecipeEntity
import javax.inject.Inject

class RecipeCacheModelMapper @Inject constructor(
    private val mapper : AnalyzedInstructionCacheModelMapper
): CacheModelMapper<RecipeCacheModel, RecipeEntity> {

    override fun mapToModel(entity: RecipeEntity): RecipeCacheModel {
        return entity.run {
            RecipeCacheModel(
                entity.id,
                entity.title,
                entity.summary,
                entity.image,
                mapper.mapToModelList(entity.analyzedInstructions),
                entity.isFavorite
            )
        }
    }

    override fun mapToEntity(model: RecipeCacheModel): RecipeEntity {
        return model.run {
            RecipeEntity(
                model.id,
                model.title,
                model.summary,
                model.image,
                mapper.mapToEntityList(model.analyzedInstructions),
                model.isFavorite
            )
        }
    }
}