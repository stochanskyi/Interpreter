package com.mars.interpreterandroid.expresions.nonTerminalExpresions.ioExpressions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.UnaryExpression

class PrintExpression: UnaryExpression() {



    override fun solve(context: Context) {
        println(firstExpression?.solve(context))
    }


}