package utils

import context.Context
import expresions.base.Expression
import java.lang.StringBuilder
import kotlin.math.exp

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
