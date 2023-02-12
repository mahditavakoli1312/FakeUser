package com.example.core.ui.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context


object ClipboardUtils {
    fun copyTextToClipboard(textToCopy: String, context: Context) {
        val clipboardManager =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
    }
}