package com.mars.interpreterandroid.data.utils

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.EmptyExpression
import com.mars.interpreterandroid.data.expresions.base.Expression

fun List<Expression>.run(context: Context): Unit {
    for (expresion in this) {
        expresion.solve(context)
    }
}

fun organizeCode(code: String): String {
    val codeBuilder = StringBuilder(code)
    var currentIndex = codeBuilder.toString().indexOf('{')
    while (currentIndex >= 0) {
        codeBuilder.insert(currentIndex + 1, '\n')
        codeBuilder.insert(currentIndex, '\n').also { currentIndex++ }
        currentIndex = codeBuilder.toString().indexOf('{', currentIndex + 1)
    }
    currentIndex = codeBuilder.toString().indexOf('}')

    while (currentIndex >= 0) {
        codeBuilder.insert(currentIndex + 1, '\n')
        codeBuilder.insert(currentIndex, '\n').also { currentIndex++ }
        currentIndex = codeBuilder.toString().indexOf('}', currentIndex + 1)
    }
    return codeBuilder.toString()
}

fun List<Expression>.trim(): List<Expression> = filter { it !is EmptyExpression }
