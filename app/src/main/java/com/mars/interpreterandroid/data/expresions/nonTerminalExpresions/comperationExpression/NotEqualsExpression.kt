package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression

class NotEqualsExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean = firstExpression?.solve(context) != secondExpression?.solve(context)

    override fun getData(): String = "!="
}