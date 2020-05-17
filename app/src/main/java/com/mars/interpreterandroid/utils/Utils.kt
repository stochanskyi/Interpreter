package com.mars.interpreterandroid.utils

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.Expression
import java.lang.StringBuilder

fun List<Expression>.run(context: Context): Unit {
    for(expresion in this) {
        expresion.solve(context)
    }
}

fun organizeCode(code:String): String {
    val codeBuilder = StringBuilder(code)
    var currentIndex = codeBuilder.toString().indexOf('{')
    while (currentIndex >= 0) {
        codeBuilder.insert(currentIndex + 1, '\n')
        codeBuilder.insert(currentIndex , '\n').also { currentIndex++ }
        currentIndex = codeBuilder.toString().indexOf('{', currentIndex + 1)
    }
    currentIndex = codeBuilder.toString().indexOf('}')

    while (currentIndex >= 0) {
        codeBuilder.insert(currentIndex + 1, '\n')
        codeBuilder.insert(currentIndex , '\n').also { currentIndex++ }
        currentIndex = codeBuilder.toString().indexOf('}', currentIndex + 1)
    }
    return codeBuilder.toString()
}
