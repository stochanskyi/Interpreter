package com.mars.interpreterandroid.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression

class MoreEqualsExpression : BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(Context)
        val rValue = secondExpression?.solve(Context)

        return MoreExpression(firstExpression, secondExpression).solve(Context)!!
                || EqualsExpression(firstExpression, secondExpression).solve(Context)!!
    }
}