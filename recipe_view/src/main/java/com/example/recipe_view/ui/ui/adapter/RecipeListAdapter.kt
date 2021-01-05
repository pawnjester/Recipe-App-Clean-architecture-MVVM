package com.example.recipe_view.ui.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.adapter.viewHolders.RecipeListViewHolder
import javax.inject.Inject

class RecipeListAdapter @Inject constructor() : RecyclerView.Adapter<RecipeListViewHolder>() {
    var viewDetailsCallback: ((RecipeModel) -> Unit)? = null
    private var recipes = mutableListOf<RecipeModel>()

    fun setRecipes(items: List<RecipeModel>) {
        this.recipes.clear()
        this.recipes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        return RecipeListViewHolder.create(
            parent,
            viewDetailsCallback ?: {})
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        holder.bind(recipes[position])
    }
}