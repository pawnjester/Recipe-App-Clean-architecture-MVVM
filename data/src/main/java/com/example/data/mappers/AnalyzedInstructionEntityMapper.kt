package com.example.data.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.InstructionEntity
import com.example.domain.model.Instruction
import javax.inject.Inject

class AnalyzedInstructionEntityMapper @Inject constructor(
    private val mapper: StepEntityMapper
) : EntityMapper<InstructionEntity, Instruction> {
    override fun mapFromEntity(entity: InstructionEntity): Instruction {
        return entity.run {
            Instruction(
                name,
                mapper.mapFromEntityList(steps)
            )
        }
    }

    override fun mapToEntity(domain: Instruction): InstructionEntity {
        return domain.run {
            InstructionEntity(
                name,
                mapper.mapFromDomainList(steps)
            )
        }
    }
}