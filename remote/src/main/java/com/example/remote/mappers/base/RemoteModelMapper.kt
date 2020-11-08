package com.example.remote.mappers.base

interface RemoteModelMapper<in M, out E> {

    fun mapFromModel(model: M) : E

}