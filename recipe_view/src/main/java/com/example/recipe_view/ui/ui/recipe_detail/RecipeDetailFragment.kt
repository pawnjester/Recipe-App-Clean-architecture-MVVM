package com.example.recipe_view.ui.ui.recipe_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.recipe_view.R
import com.example.recipe_view.databinding.FragmentRecipeDetailBinding
import com.example.recipe_view.ui.model.IngredientModel
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.ext.loadImage
import com.example.recipe_view.ui.utils.observe
import com.example.recipe_view.ui.utils.setTextFromHtml
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {

    private val recipeArgs: RecipeDetailFragmentArgs by navArgs()

    private val viewModel: RecipeDetailViewModel by viewModels()

    private var _binding: FragmentRecipeDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        Log.e("NNNN", recipeArgs.recipe.toString())

        viewModel.setRecipeDetail(recipeArgs.recipe)

        observe(viewModel.recipe, ::init)

        viewModel.state.observe(viewLifecycleOwner, Observer { isFavorite ->
            if (isFavorite) {
                binding.toolbar.menu?.get(0)?.icon =
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_red_favorite)
            } else {
                binding.toolbar.menu?.get(0)?.icon =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_favorite_border_24
                    )
            }
        })

        binding.toolbar.menu?.get(0)?.setOnMenuItemClickListener {
            viewModel.favoriteRecipe()
            return@setOnMenuItemClickListener true
        }
    }

    private fun init(recipe: RecipeModel?) {
        recipe?.let {
            binding.tvTitle.text = recipe.title
            binding.imgBackdrop.loadImage(recipe.image ?: "")
            binding.tvHintSummary.setTextFromHtml(recipe.summary)
            binding.tvSteps.text =
                viewModel.setFormattedInstructions(recipe.analyzedInstructions)
            val ingredientsList =
                viewModel.setFormattedIngredients(recipe.analyzedInstructions)
            setIngredients(ingredientsList)
            setFavoriteStatus(recipe)
        }
    }

    private fun setIngredients(ingredients: List<IngredientModel>) {
        ingredients.forEach { ingredientsList ->
            val inflater = LayoutInflater.from(chip_group_types.context)
            val layoutRes = R.layout.item_ingredients_category
            val parent = chip_group_types
            val chip = (inflater.inflate(layoutRes, parent, false) as Chip).apply {
                text = ingredientsList.name
                isCheckable = false
                isClickable = false
            }

            chip_group_types.addView(chip)
        }
    }

    private fun setFavoriteStatus(recipe: RecipeModel) = if (recipe.isFavorite) {
        binding.toolbar.menu?.get(0)?.icon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_red_favorite)
    } else {
        binding.toolbar.menu?.get(0)?.icon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_favorite_border_24)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}