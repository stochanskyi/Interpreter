package com.mars.interpreterandroid.expresions.terminalExpresions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.TerminalExpression

class VariableExpression(val name: String): TerminalExpression {

    override fun solve(context: Context): Any {
        return context.variables.getValue(name)!!
    }
}