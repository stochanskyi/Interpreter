package com.mars.interpreterandroid

import android.content.Context

object FileAdapter {
    fun readInputFile(context: Context): List<String> {
        val inputStream = context.resources.openRawResource(R.raw.code)
        return inputStream.bufferedReader().use { it.readLines() }
    }
}