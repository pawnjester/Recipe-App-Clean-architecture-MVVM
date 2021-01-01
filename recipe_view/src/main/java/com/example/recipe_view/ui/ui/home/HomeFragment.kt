package com.example.recipe_view.ui.ui.home

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.ui.adapter.RecipeListAdapter
import com.example.recipe_view.ui.utils.MarginItemDecoration
import com.example.recipe_view.ui.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var recipeAdapter: RecipeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        subscribeToUi()

        search_view_home.setOnFocusChangeListener { _, _ ->
            home_layout.transitionToEnd()
        }
        search_view_home.doOnTextChanged { text, _, _, _ ->
            text?.let {
                viewModel.getRecipes(it.toString())
            }
        }

        recipeAdapter.viewDetailsCallback = {
            val action =
                HomeFragmentDirections.actionNavigationHomeToRecipeDetailFragment(it)
            findNavController().navigate(action)
        }

        recipeAdapter.favoriteRecipeCallback = {
            viewModel.favoriteRecipe(it)
        }

        home_layout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                p1: Int,
                p2: Int,
                p3: Float
            ) =
                if (motionLayout?.progress == 0.0f) {
                    hideKeyboard()
                } else {
                    // this is end
                }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}

        })
    }

    private fun setupRecyclerView() {
        recipe_rv_home.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )
        recipe_rv_home.addItemDecoration(MarginItemDecoration(16))
        recipe_rv_home.adapter = recipeAdapter
    }

    private fun subscribeToUi() {
        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LatestNewsUiState.Loading -> {
                    search_results_progress_bar.visibility = View.VISIBLE
                }
                is LatestNewsUiState.Success -> {
                    search_results_progress_bar.visibility = View.GONE
                    recipeAdapter.setRecipes(it.recipes)
                }
                is LatestNewsUiState.Error -> {
                    search_results_progress_bar.visibility = View.GONE
                }
            }
        })
    }
}