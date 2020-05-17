package com.mars.interpreterandroid.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression

class NotEqualsExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean = firstExpression?.solve(Context) != secondExpression?.solve(Context)

}