package com.example.recipe_view.ui.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.presentation.mvi.MVIView
import com.example.recipe_view.R
import com.example.recipe_view.databinding.FragmentHomeBinding
import com.example.recipe_view.ui.ui.ext.observe
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewIntent
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewState
import com.example.recipe_view.ui.ui.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.merge

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),
    MVIView<RecipeListViewIntent, RecipeListViewState> {

    private val viewModel: HomeViewModel by viewModels()

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    private val loadRecipesList = ConflatedBroadcastChannel<RecipeListViewIntent.LoadRecipesLists>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.processIntent(intents)
        viewModel.viewState.observe(viewLifecycleOwner, ::render)

//        setupRecyclerView()

//        subscribeToUi()

//        binding.searchViewHome.setOnFocusChangeListener { _, _ ->
//            home_layout.transitionToEnd()
//        }
//        binding.searchViewHome.doOnTextChanged { text, _, _, _ ->
//            text?.let {
//                viewModel.getRecipes(it.toString())
//            }
//        }

//        recipeAdapter.viewDetailsCallback = {
//            val action =
//                HomeFragmentDirections.actionNavigationHomeToRecipeDetailFragment(it)
//            navController.navigate(action)
//        }
//
//        binding.homeLayout.setTransitionListener(object : MotionLayout.TransitionListener {
//            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
//
//            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
//            }
//
//            override fun onTransitionChange(
//                motionLayout: MotionLayout?,
//                p1: Int,
//                p2: Int,
//                p3: Float
//            ) =
//                if (motionLayout?.progress == 0.0f) {
//                    hideKeyboard()
//                } else {
//                    // this is end
//                }
//
//            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}
//
//        })
    }

    override fun render(state: RecipeListViewState) {
        binding.recipeList.render(state)
    }

    override val intents: Flow<RecipeListViewIntent>
        get() = merge(
            loadRecipesList.asFlow(),
            binding.recipeList.intents,
        )
}