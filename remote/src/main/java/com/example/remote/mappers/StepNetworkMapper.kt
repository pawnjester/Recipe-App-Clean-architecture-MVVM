package com.example.remote.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.StepEntity
import com.example.remote.models.StepNetworkModel
import javax.inject.Inject

class StepNetworkMapper @Inject constructor(
    private val mapper: IngredientsNetworkMapper
) : EntityMapper<StepEntity, StepNetworkModel> {

    override fun mapFromEntity(entity: StepEntity): StepNetworkModel {
        return entity.run {
            StepNetworkModel(
                number,
                step,
                mapper.mapFromEntityList(ingredients)
            )
        }
    }

    override fun mapToEntity(domain: StepNetworkModel): StepEntity {
        return domain.run {
            StepEntity(
                number,
                step,
                mapper.mapFromDomainList(ingredients)
            )
        }
    }
}