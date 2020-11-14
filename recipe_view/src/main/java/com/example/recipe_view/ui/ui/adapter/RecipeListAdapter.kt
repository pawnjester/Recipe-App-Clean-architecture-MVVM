package com.example.recipe_view.ui.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.ui.model.RecipeModel

class RecipeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var recipes = mutableListOf<RecipeModel>()

    fun setRecipes(items: List<RecipeModel>) {
        this.recipes.clear()
        this.recipes.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}