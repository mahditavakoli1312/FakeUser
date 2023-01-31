package com.example.core.ui

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {

    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val resourceID: Int,
        vararg val args: Any
    ) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(resourceID, *args)
        }
    }
}
