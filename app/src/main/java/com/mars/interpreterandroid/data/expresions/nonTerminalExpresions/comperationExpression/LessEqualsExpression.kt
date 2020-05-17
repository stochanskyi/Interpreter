package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression

class LessEqualsExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(context)
        val rValue = secondExpression?.solve(context)

        return LessExpression(firstExpression, secondExpression).solve(context)!!
                || EqualsExpression(firstExpression, secondExpression).solve(context)!!
    }

    override fun getData(): String = "<="
}