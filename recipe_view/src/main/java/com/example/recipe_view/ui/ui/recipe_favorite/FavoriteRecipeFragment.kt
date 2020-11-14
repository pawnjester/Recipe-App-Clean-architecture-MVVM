package com.example.recipe_view.ui.ui.recipe_favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.recipe_view.R

class FavoriteRecipeFragment : Fragment(R.layout.fragment_favorite_recipe) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteRecipeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}