package utils

import context.Context
import expresions.base.Expression
import kotlin.math.exp

fun List<Expression>.solve(context: Context): Unit {
    for(expresion in this) {
        expresion.solve(context)
    }
}