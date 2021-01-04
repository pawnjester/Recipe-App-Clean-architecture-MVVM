package com.example.cache.room

import androidx.room.*
import com.example.cache.models.RecipeCacheModel
import com.example.cache.models.RecipeCacheModel.Companion.TABLE_NAME

@Dao
interface RecipeDao {

    @Query("select * from $TABLE_NAME")
    suspend fun getProducts(): List<RecipeCacheModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun favoriteRecipe(recipe: RecipeCacheModel)

    @Query("delete from $TABLE_NAME where title = :title")
    suspend fun removeRecipe(title : String)

}