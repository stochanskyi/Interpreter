package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.ioExpressions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.UnaryExpression

class PrintExpression: UnaryExpression() {

    override fun solve(context: Context) {
        context.outputBlock(firstExpression?.solve(context).toString())
        println(firstExpression?.solve(context))
    }

    override fun getData(): String = "print"
}