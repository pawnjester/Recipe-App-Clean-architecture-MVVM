package com.example.recipe_view.ui.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.mvi.MVIView
import com.example.recipe_view.databinding.LayoutRecipeListBinding
import com.example.recipe_view.ui.navigation.NavigationDispatcher
import com.example.recipe_view.ui.ui.adapter.RecipeListAdapter
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewIntent
import com.example.recipe_view.ui.ui.home.mvi.RecipeListViewState
import com.example.recipe_view.ui.utils.MarginItemDecoration
import com.example.recipe_view.ui.utils.show
import com.example.recipe_view.ui.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs), MVIView<RecipeListViewIntent, RecipeListViewState> {


    private var binding: LayoutRecipeListBinding

    @Inject
    lateinit var recipeListAdapter: RecipeListAdapter

    @Inject
    lateinit var navigator: NavigationDispatcher


    init {
        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutRecipeListBinding.inflate(inflater, this, true)
        with(binding) {

            recipeRvHome.apply {
                layoutManager = LinearLayoutManager(
                    context, RecyclerView.VERTICAL, false
                )
                addItemDecoration(MarginItemDecoration(16))
                adapter = recipeListAdapter.apply {
                    viewDetailsCallback = navigator::openRecipeListDetail
                }
            }
        }

    }


    override fun render(state: RecipeListViewState) {
        when (state) {
            is RecipeListViewState.Error -> {
                binding.searchResultsProgressBar.show(false)
                context.showToast("Cannot fetch results, Please check your internet connection")
            }
            RecipeListViewState.Idle -> {

            }
            RecipeListViewState.Loading -> {
                binding.searchResultsProgressBar.show(true)
            }
            is RecipeListViewState.RecipesListLoaded -> {
                binding.searchResultsProgressBar.show(false)
                recipeListAdapter.submitList(state.listWithRecipes)
            }
        }
    }

    private val getRecipeListIntent: Flow<RecipeListViewIntent>
        get() = flowOf(RecipeListViewIntent.LoadRecipesLists(""))

    override val intents: Flow<RecipeListViewIntent>
        get() = getRecipeListIntent
}