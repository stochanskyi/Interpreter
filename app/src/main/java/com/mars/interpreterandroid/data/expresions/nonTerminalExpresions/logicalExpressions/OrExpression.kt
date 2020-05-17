package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.logicalExpressions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import java.lang.Exception

class OrExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val lValue = firstExpression as? BooleanExpression?: throw Exception("Not boolean first operator for or(||) expression")
        val rValue = secondExpression as? BooleanExpression?: throw Exception("Not boolean second operator for or(||) expression")

        return lValue.solve(context) || rValue.solve(context)
    }

    override fun getData(): String = "||"
}