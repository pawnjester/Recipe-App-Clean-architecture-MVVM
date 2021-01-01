package com.example.recipe_view.ui.ui.recipe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.recipe_view.R
import com.example.recipe_view.ui.model.IngredientModel
import com.example.recipe_view.ui.ui.ext.loadImage
import com.example.recipe_view.ui.utils.setTextFromHtml
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

@AndroidEntryPoint
class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {

    private val recipeArgs: RecipeDetailFragmentArgs by navArgs()

    private val viewModel: RecipeDetailViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        initializeView()

    }

    private fun initializeView() {
        recipeArgs.run {
            tv_title.text = recipe?.title
            img_backdrop.loadImage(recipe?.image ?: "")
            tv_hint_summary.setTextFromHtml(recipe?.summary)
            tv_steps.text = viewModel.setFormattedInstructions(recipe?.analyzedInstructions)
            val ingredientsList = viewModel.setFormattedIngredients(recipe?.analyzedInstructions)
            setIngredients(ingredientsList)
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
}