package com.mars.interpreterandroid.expresions.nonTerminalExpresions.variables

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import com.mars.interpreterandroid.expresions.terminalExpresions.VariableExpression

class InitExpression: BinaryExpression() {
    override fun solve(context: Context) {
        val lValue = when(firstExpression) {
            is VariableExpression -> firstExpression
            is CreateVariableExpression -> firstExpression?.solve(Context)
            else -> throw Exception("LValue of init(=) expression is not variable")
        } as VariableExpression

        val rValue = secondExpression?.solve(Context)?: throw Exception("RValue of init(=) expression is incorrect")

        if(Context.variables.isInitialized(lValue.name) && rValue::class != lValue.solve(Context)::class) throw Exception("Type error")
        Context.variables.setValue(lValue.name, rValue)
    }

}