package com.example.recipe_view.ui.ui.recipe_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipe_view.R

class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(">>>>", "here")
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