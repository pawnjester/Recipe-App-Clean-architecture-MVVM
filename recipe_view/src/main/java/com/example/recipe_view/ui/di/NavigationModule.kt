package com.example.recipe_view.ui.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.recipe_view.R
import com.example.recipe_view.ui.navigation.NavigationDispatcher
import com.example.recipe_view.ui.navigation.NavigationDispatcherImpl
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewReducer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@InstallIn(ActivityComponent::class)
@Module
object NavigationModule {

    @Provides
    fun providesNavController(activity: Activity): NavController =
        activity.findNavController(R.id.fragment_container)
}