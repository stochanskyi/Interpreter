package com.mars.interpreterandroid.expresions.nonTerminalExpresions.logicalExpressions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.UnaryExpression
import java.lang.Exception

class NotExpression: UnaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val value = firstExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean operator for not(!!) expression")
        return !value
    }

}