package com.example.recipe_view.ui.ui.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.model.RecipeModel

class RecipeListViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

    fun bind(item: RecipeModel) {

    }

    companion object {
        fun create(
            parent: ViewGroup
        ) : RecipeListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.recipe_item, parent, false
            )
            return RecipeListViewHolder(view)
        }
    }
}