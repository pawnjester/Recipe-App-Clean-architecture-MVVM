package com.example.recipe_view.ui.ui.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.ext.loadImage
import kotlinx.android.synthetic.main.recipe_item.view.*

class RecipeListViewHolder(
    private val view: View,
    private val viewDetailsCallback: (RecipeModel) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(item: RecipeModel) {
        view.recipe_name.text = item.title
        view.recipe_image.loadImage(item.image)
        view.recipe_image.setOnClickListener {
            viewDetailsCallback.invoke(item)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            viewDetailsCallback: (RecipeModel) -> Unit
        ): RecipeListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.recipe_item, parent, false
            )
            return RecipeListViewHolder(view, viewDetailsCallback)
        }
    }
}