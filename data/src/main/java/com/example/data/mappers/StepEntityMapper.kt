package com.example.data.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.StepEntity
import com.example.domain.model.Step
import javax.inject.Inject

class StepEntityMapper @Inject constructor(
    private val mapper: IngredientsEntityMapper
) : EntityMapper<StepEntity, Step> {

    override fun mapFromEntity(entity: StepEntity): Step {
        return entity.run {
            Step(
                number,
                step,
                mapper.mapFromEntityList(ingredients)
            )
        }
    }

    override fun mapToEntity(domain: Step): StepEntity {
        return domain.run {
            StepEntity(
                number,
                step,
                mapper.mapFromDomainList(ingredients)
            )
        }
    }
}