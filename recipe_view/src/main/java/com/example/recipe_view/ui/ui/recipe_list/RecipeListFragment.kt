package com.example.recipe_view.ui.ui.recipe_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recipe_view.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private val viewModel: RecipeListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRecipes("pasta")
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecipeListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}