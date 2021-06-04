package com.example.recipe_view.ui.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.adapter.viewHolders.RecipeListViewHolder
import javax.inject.Inject

class RecipeListAdapter @Inject constructor() :
    ListAdapter<RecipeModel, RecipeListViewHolder>(RECIPE_LIST_COMPARATOR) {
    var viewDetailsCallback: ((RecipeModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        return RecipeListViewHolder.create(
            parent,
            viewDetailsCallback ?: {})
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val RECIPE_LIST_COMPARATOR = object : DiffUtil.ItemCallback<RecipeModel>() {
            override fun areItemsTheSame(oldItem: RecipeModel, newItem: RecipeModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RecipeModel, newItem: RecipeModel) =
                oldItem == newItem

        }
    }
}