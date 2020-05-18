package com.mars.interpreterandroid.presentation.activities.main

import org.w3c.dom.Text

interface Navigation {

    fun openStartScreen()

    fun openTreeScreen(code: String)

    fun openOptimisedScreen(code: String)

    fun openResultScreen(result: String)
}