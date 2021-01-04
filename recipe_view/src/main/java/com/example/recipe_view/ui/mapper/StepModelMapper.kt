package com.example.recipe_view.ui.mapper

import com.example.domain.model.Step
import com.example.recipe_view.ui.mapper.base.ModelMapper
import com.example.recipe_view.ui.model.StepModel
import javax.inject.Inject

class StepModelMapper @Inject constructor(
    private val mapper: IngredientsModelMapper
) : ModelMapper<Step, StepModel> {

    override fun mapToModel(domain: StepModel): Step {
        return domain.run {
            Step(
                number,
                step,
                mapper.mapToModelList(ingredients)
            )
        }
    }

    override fun mapToDomain(model: Step): StepModel {
        return model.run {
            StepModel(
                number,
                step,
                mapper.mapToDomainList(ingredients)
            )
        }
    }
}