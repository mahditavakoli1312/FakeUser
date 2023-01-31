package com.example.core.ui

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun showSnack(view: View, message: String) {
    val snackbar = Snackbar.make(
        view, message,
        Snackbar.LENGTH_LONG
    )
    snackbar.setActionTextColor(Color.BLUE)
    val snackbarView = snackbar.view
    snackbarView.setBackgroundColor(Color.LTGRAY)
    val textView =
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.BLUE)
    textView.layoutDirection = View.LAYOUT_DIRECTION_RTL
    snackbar.show()
}