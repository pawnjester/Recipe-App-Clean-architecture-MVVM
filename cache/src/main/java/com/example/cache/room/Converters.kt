package com.example.cache.room

import androidx.room.TypeConverter
import com.example.cache.models.IngredientCacheModel
import com.example.cache.models.InstructionCacheModel
import com.example.cache.models.StepCacheModel
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun fromIngredientObject(ingredient: IngredientCacheModel?): String {
        val type = object : TypeToken<IngredientCacheModel?>() {}.type
        return Gson().toJson(ingredient, type)
    }

    @TypeConverter
    fun toIngredientObject(ingredient: String?): IngredientCacheModel? {
        val type = object : TypeToken<IngredientCacheModel?>() {}.type
        return Gson().fromJson(ingredient, type)
    }

    @TypeConverter
    fun fromStepObject(step: StepCacheModel?): String {
        val type = object : TypeToken<StepCacheModel?>() {}.type
        return Gson().toJson(step, type)
    }

    @TypeConverter
    fun toStepObject(step: String?): StepCacheModel? {
        val type = object : TypeToken<StepCacheModel?>() {}.type
        return Gson().fromJson(step, type)
    }

    @TypeConverter
    fun fromInstructionObject(instruction: InstructionCacheModel?): String {
        val type = object : TypeToken<InstructionCacheModel?>() {}.type
        return Gson().toJson(instruction, type)
    }

    @TypeConverter
    fun toInstructionObject(instruction: String?): InstructionCacheModel? {
        val type = object : TypeToken<InstructionCacheModel?>() {}.type
        return Gson().fromJson(instruction, type)
    }

    @TypeConverter
    fun fromListInstructionObject(instructions: List<InstructionCacheModel>?): String {
        val type = object : TypeToken<List<InstructionCacheModel>?>() {}.type
        return Gson().toJson(instructions, type)
    }

    @TypeConverter
    fun toListInstructionObject(instruction: String?): List<InstructionCacheModel>? {
        val type = object : TypeToken<List<InstructionCacheModel>?>() {}.type
        return Gson().fromJson(instruction, type)
    }

    @TypeConverter
    fun fromListStringObject(list: List<String>?): String? {
        val type = object : TypeToken<List<String>?>() {}.type
        return Gson().toJson(list, type)
    }

    @TypeConverter
    fun toListStringObject(list: String?): List<String>? {
        val type = object : TypeToken<List<String>?>() {}.type
        return Gson().fromJson(list, type)
    }
}