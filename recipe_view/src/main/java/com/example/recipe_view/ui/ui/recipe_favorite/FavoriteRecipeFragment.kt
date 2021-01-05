package com.example.recipe_view.ui.ui.recipe_favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.ui.adapter.FavoriteRecipeAdapter
import com.example.recipe_view.ui.ui.home.LatestNewsUiState
import com.example.recipe_view.ui.utils.MarginItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite_recipe.*
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteRecipeFragment : Fragment(R.layout.fragment_favorite_recipe) {

    private val viewModel: FavoriteRecipeViewModel by viewModels()

    @Inject
    lateinit var favoriteRecipeAdapter: FavoriteRecipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        subscribeToUi()

        viewModel.getFavoriteRecipes()

        favoriteRecipeAdapter.favoriteRecipeCallback = {
            val action =
                FavoriteRecipeFragmentDirections.actionFavoriteRecipeFragmentToRecipeDetailFragment(
                    it
                )
            findNavController().navigate(action)
        }
    }

    private fun setupRecyclerView() {
        favorite_rv.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )
        favorite_rv.addItemDecoration(MarginItemDecoration(16))
        favorite_rv.adapter = favoriteRecipeAdapter
    }

    private fun subscribeToUi() {
        viewModel.favoriteRecipes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LatestNewsUiState.Success -> {
                    favoriteRecipeAdapter.setFavoriteRecipesList(it.recipes)
                }
                LatestNewsUiState.Loading -> {
                }
                is LatestNewsUiState.Error -> {

                }
            }
        })
    }
}