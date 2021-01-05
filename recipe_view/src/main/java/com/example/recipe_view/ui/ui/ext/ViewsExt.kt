package com.example.recipe_view.ui.ui.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.recipe_view.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.ic_placeholder_food)
        .into(this)

}