package com.example.remote.mappers

import com.example.data.model.RecipeEntity
import com.example.remote.mappers.base.RemoteModelMapper
import com.example.remote.models.RecipeNetworkModel
import javax.inject.Inject

class RecipeNetworkModelMapper @Inject constructor(
    private val mapper: AnalyzedInstructionNetworkMapper
) : RemoteModelMapper<RecipeNetworkModel, RecipeEntity> {

    override fun mapFromModel(model: RecipeNetworkModel): RecipeEntity {
        return RecipeEntity(
            model.id,
            model.title,
            model.summary,
            model.image,
            mapper.mapFromDomainList(model.analyzedInstructions)
        )
    }
}