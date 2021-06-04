package com.example.recipe_view.ui.navigation

import androidx.navigation.NavController
import com.example.recipe_view.ui.model.RecipeModel
import javax.inject.Inject
import javax.inject.Provider

class NavigationDispatcherImpl @Inject constructor(
    private val navController: Provider<NavController>
) : NavigationDispatcher{

    override fun openRecipeListDetail(model: RecipeModel) {
//        navController.get().navigate(
////            HomeFragmentDirections.actionNavigationHomeToRecipeDetailFragment(it)
//        )
    }
}