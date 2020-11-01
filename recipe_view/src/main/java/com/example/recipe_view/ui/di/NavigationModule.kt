package com.example.recipe_view.ui.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.recipe_view.R
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@InstallIn(ActivityComponent::class)
@Module
object NavigationModule {

    fun providesNavController(activity: Activity) :NavController =
        activity.findNavController(R.id.fragment_container)
}