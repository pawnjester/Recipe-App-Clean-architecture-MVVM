package com.example.core.di

import com.example.core.executor.PostExecutionThreadImpl
import com.example.domain.executor.PostExecutorThread
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class ExecutorModule {

    @Binds
    abstract fun providesPostExecution(postExecutionThreadImpl: PostExecutionThreadImpl) : PostExecutorThread
}