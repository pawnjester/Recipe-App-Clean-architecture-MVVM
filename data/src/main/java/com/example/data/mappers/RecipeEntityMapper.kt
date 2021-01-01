package com.example.data.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.RecipeEntity
import com.example.domain.model.Recipe
import javax.inject.Inject

class RecipeEntityMapper @Inject constructor(
    private val mapper: AnalyzedInstructionEntityMapper
) : EntityMapper<RecipeEntity, Recipe> {

    override fun mapFromEntity(entity: RecipeEntity): Recipe {
        return entity.run {
            Recipe(
                entity.id,
                entity.title,
                entity.summary,
                entity.image,
                mapper.mapFromEntityList(entity.analyzedInstructions)
            )
        }
    }

    override fun mapToEntity(domain: Recipe): RecipeEntity {
        return domain.run {
            RecipeEntity(
                domain.id, domain.title,
                domain.summary,
                domain.image,
                mapper.mapFromDomainList(domain.analyzedInstructions)
            )
        }
    }
}