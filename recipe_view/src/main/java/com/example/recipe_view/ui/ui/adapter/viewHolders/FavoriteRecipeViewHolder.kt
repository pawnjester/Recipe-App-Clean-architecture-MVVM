package com.example.recipe_view.ui.ui.adapter.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_view.R
import com.example.recipe_view.ui.model.RecipeModel
import com.example.recipe_view.ui.ui.ext.loadImage
import kotlinx.android.synthetic.main.favorite_recipe_item.view.*

class FavoriteRecipeViewHolder(
    private val view: View,
    private val favoriteRecipeCallback: (RecipeModel) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(item: RecipeModel) {
        view.run {
            favorite_recipe_name.text = item.title
            favorite_recipe_image.loadImage(item.image)

            setOnClickListener { favoriteRecipeCallback.invoke(item) }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            favoriteRecipeCallback: (RecipeModel) -> Unit
        ): FavoriteRecipeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_recipe_item, parent, false
            )
            return FavoriteRecipeViewHolder(view, favoriteRecipeCallback)
        }
    }
}