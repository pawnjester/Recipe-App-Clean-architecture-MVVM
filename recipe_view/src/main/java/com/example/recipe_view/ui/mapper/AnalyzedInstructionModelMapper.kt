package com.example.recipe_view.ui.mapper

import com.example.domain.model.Instruction
import com.example.recipe_view.ui.mapper.base.ModelMapper
import com.example.recipe_view.ui.model.InstructionModel
import javax.inject.Inject

class AnalyzedInstructionModelMapper @Inject constructor(
    private val mapper: StepModelMapper
) : ModelMapper<Instruction, InstructionModel> {
    override fun mapToModel(domain: InstructionModel): Instruction {
        return domain.run {
            Instruction(
                name,
                mapper.mapToModelList(steps)
            )
        }
    }

    override fun mapToDomain(model: Instruction): InstructionModel {
        return model.run {
            InstructionModel(
                name,
                mapper.mapToDomainList(steps)
            )
        }
    }
}