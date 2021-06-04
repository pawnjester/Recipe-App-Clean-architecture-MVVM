package com.example.recipe_view.ui.di

import com.example.recipe_view.ui.navigation.NavigationDispatcher
import com.example.recipe_view.ui.navigation.NavigationDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationDispatcherModule {

    @Binds
    abstract fun providesNavigationDispatcher(dispatcher: NavigationDispatcherImpl): NavigationDispatcher
}