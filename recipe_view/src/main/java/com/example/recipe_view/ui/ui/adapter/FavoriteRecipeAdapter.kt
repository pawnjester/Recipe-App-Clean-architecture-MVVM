package com.example.recipe_view.ui.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.adapter.viewHolders.FavoriteRecipeViewHolder
import javax.inject.Inject

class FavoriteRecipeAdapter @Inject constructor(
) : RecyclerView.Adapter<FavoriteRecipeViewHolder>() {

    var favoriteRecipeCallback: ((RecipeModel) -> Unit)? = null
    private var favoriteRecipes = mutableListOf<RecipeModel>()

    fun setFavoriteRecipesList(items: List<RecipeModel>) {
        this.favoriteRecipes.clear()
        this.favoriteRecipes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRecipeViewHolder {
        return FavoriteRecipeViewHolder.create(parent, favoriteRecipeCallback ?: {})
    }

    override fun getItemCount(): Int = favoriteRecipes.size

    override fun onBindViewHolder(holder: FavoriteRecipeViewHolder, position: Int) {
        holder.bind(favoriteRecipes[position])
    }
}