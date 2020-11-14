package com.example.recipe_view.ui.ui.recipe_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipe_view.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe_list.*

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getRecipes(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.getRecipes(newText ?: "")
                }
                return true
            }

        })
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