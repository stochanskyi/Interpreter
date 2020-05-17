package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.variables

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.UnaryExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.VariableExpression

class CreateVariableExpression: UnaryExpression() {

    override fun solve(context: Context): VariableExpression {
        val variable = firstExpression as? VariableExpression?: throw Exception("Attempt to create variable error")
        context.variables.createVar(variable.name)
        return variable
    }

    override fun getData(): String = "var"
}