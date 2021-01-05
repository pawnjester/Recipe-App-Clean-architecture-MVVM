package com.example.cache.mappers

import com.example.cache.mappers.base.CacheModelMapper
import com.example.cache.models.InstructionCacheModel
import com.example.data.model.InstructionEntity
import javax.inject.Inject

class AnalyzedInstructionCacheModelMapper @Inject constructor(
    private val mapper: StepCacheModelMapper
) : CacheModelMapper<InstructionCacheModel, InstructionEntity> {
    override fun mapToModel(entity: InstructionEntity): InstructionCacheModel {
        return entity.run {
            InstructionCacheModel(
                name,
                mapper.mapToModelList(steps)
            )
        }
    }

    override fun mapToEntity(model: InstructionCacheModel): InstructionEntity {
        return model.run {
            InstructionEntity(
                name ?: "",
                mapper.mapToEntityList(steps ?: emptyList())
            )
        }
    }
}