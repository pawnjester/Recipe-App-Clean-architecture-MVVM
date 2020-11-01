package com.example.data.mappers

import com.example.data.mappers.base.EntityMapper
import com.example.data.model.RecipeEntity
import com.example.domain.model.Recipe
import javax.inject.Inject

class RecipeEntityMapper @Inject constructor() : EntityMapper<RecipeEntity, Recipe> {

    override fun mapFromEntity(entity: RecipeEntity): Recipe {
        return entity.run {
            Recipe(
                entity.id,
                entity.title,
                entity.summary,
                entity.image
            )
        }
    }

    override fun mapToEntity(domain: Recipe): RecipeEntity {
        return domain.run {
            RecipeEntity(domain.id, domain.title, domain.summary, domain.image)
        }
    }
}