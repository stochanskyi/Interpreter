package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.variables

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.VariableExpression

class InitExpression : BinaryExpression() {
    override fun solve(context: Context) {
        val lValue = when (firstExpression) {
            is VariableExpression -> firstExpression
            is CreateVariableExpression -> firstExpression?.solve(context)
            else -> throw Exception("LValue of init(=) expression is not variable")
        } as VariableExpression

        val rValue = secondExpression?.solve(context)
            ?: throw Exception("RValue of init(=) expression is incorrect")

        if (context.variables.isInitialized(lValue.name) && rValue::class != lValue.solve(context)::class) throw Exception(
            "Type error"
        )
        context.variables.setValue(lValue.name, rValue)
    }

    override fun getData(): String = "="
}