package com.example.recipe_view.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.databinding.FragmentHomeBinding
import com.example.recipe_view.ui.ui.adapter.RecipeListAdapter
import com.example.recipe_view.ui.utils.MarginItemDecoration
import com.example.recipe_view.ui.utils.hideKeyboard
import com.example.recipe_view.ui.utils.show
import com.example.recipe_view.ui.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var recipeAdapter: RecipeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        subscribeToUi()

        binding.searchViewHome.setOnFocusChangeListener { _, _ ->
            home_layout.transitionToEnd()
        }
        binding.searchViewHome.doOnTextChanged { text, _, _, _ ->
            text?.let {
                viewModel.getRecipes(it.toString())
            }
        }

        recipeAdapter.viewDetailsCallback = {
            val action =
                HomeFragmentDirections.actionNavigationHomeToRecipeDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.homeLayout.setTransitionListener(object : MotionLayout.TransitionListener {
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
        binding.recipeRvHome.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false
        )
        binding.recipeRvHome.addItemDecoration(MarginItemDecoration(16))
        binding.recipeRvHome.adapter = recipeAdapter
    }

    private fun subscribeToUi() {
        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LatestNewsUiState.Loading -> {
                    binding.searchResultsProgressBar.show(true)
                }
                is LatestNewsUiState.Success -> {
                    binding.searchResultsProgressBar.show(false)
                    recipeAdapter.setRecipes(it.recipes)
                }
                is LatestNewsUiState.Error -> {
                    binding.searchResultsProgressBar.show(false)
                    showToast("Cannot fetch results, Please check your internet connection")
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}