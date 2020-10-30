package com.example.recipe_view.ui.ui.recipe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipe_view.R

class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecipeDetailFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}