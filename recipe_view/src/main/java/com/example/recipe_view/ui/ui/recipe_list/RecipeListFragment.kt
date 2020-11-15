package com.example.recipe_view.ui.ui.recipe_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.ui.adapter.RecipeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe_list.*
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private val viewModel: RecipeListViewModel by viewModels()

    @Inject
    lateinit var recipeAdapter: RecipeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        setupRecyclerView()
        subscribeToUi()
        recipeAdapter.viewDetailsCallback = {
            val action =
                RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment()
            findNavController().navigate(action)
        }

        recipeAdapter.favoriteRecipeCallback = {
            viewModel.favoriteRecipe(it)
        }

    }


    private fun setupRecyclerView() {
        recipes_rv.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )
        recipes_rv.adapter = recipeAdapter
    }

    private fun subscribeToUi() {
        viewModel.recipes.observe(requireActivity(), Observer {
            recipeAdapter.setRecipes(it)
        })
    }


    companion object {
    }
}