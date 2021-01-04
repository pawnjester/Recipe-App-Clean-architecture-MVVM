package com.example.remote.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.InstructionEntity
import com.example.remote.models.InstructionNetworkModel
import javax.inject.Inject

class AnalyzedInstructionNetworkMapper @Inject constructor(
    private val mapper: StepNetworkMapper
) : EntityMapper<InstructionEntity, InstructionNetworkModel> {
    override fun mapFromEntity(entity: InstructionEntity): InstructionNetworkModel {
        return entity.run {
            InstructionNetworkModel(
                name,
                mapper.mapFromEntityList(steps)
            )
        }
    }

    override fun mapToEntity(domain: InstructionNetworkModel): InstructionEntity {
        return domain.run {
            InstructionEntity(
                name,
                mapper.mapFromDomainList(steps)
            )
        }
    }
}