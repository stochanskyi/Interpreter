package com.mars.interpreterandroid.data.expresions.terminalExpresions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.TerminalExpression

class VariableExpression(val name: String): TerminalExpression {

    override fun solve(context: Context): Any {
        return context.variables.getValue(name)!!
    }

    override fun getData(): String = name
}