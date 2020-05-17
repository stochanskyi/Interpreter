package com.mars

import android.content.Context
import com.mars.interpreterandroid.R

object FileAdapter {
    fun readInputFile(context: Context): List<String> {
        val inputStream = context.resources.openRawResource(R.raw.code)
        return inputStream.bufferedReader().use { it.readLines() }
    }
}