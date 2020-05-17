package com.mars.interpreterandroid.expresions.nonTerminalExpresions.variables

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.UnaryExpression
import com.mars.interpreterandroid.expresions.terminalExpresions.VariableExpression

class CreateVariableExpression: UnaryExpression() {

    override fun solve(context: Context): VariableExpression {
        val variable = firstExpression as? VariableExpression?: throw Exception("Attempt to create variable error")
        context.variables.createVar(variable.name)
        return variable
    }

}