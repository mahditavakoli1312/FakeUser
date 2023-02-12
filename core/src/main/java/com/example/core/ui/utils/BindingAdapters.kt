package com.example.core.ui.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("loadImg")
fun loadImg(imageView: ImageView, imageUrl: String?) {
    Log.d("mahdi", "loadImg: $imageUrl")
    if (imageUrl != null && imageUrl != "") {
        imageView.load(
            imageUrl
        ) {
            error(com.google.android.material.R.drawable.ic_clock_black_24dp)
            transformations(RoundedCornersTransformation(30F))
        }
    }
}

@BindingAdapter("viewVisibility")
fun viewVisibility(view: View, visibility: Boolean) {
    if (visibility) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.INVISIBLE
    }
}