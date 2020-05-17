package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.logicalExpressions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.UnaryExpression
import java.lang.Exception

class NotExpression: UnaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val value = firstExpression?.solve(context) as? Boolean?: throw Exception("Not boolean operator for not(!!) expression")
        return !value
    }

    override fun getData(): String = "!"

}