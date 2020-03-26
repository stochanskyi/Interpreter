package expresions.nonTerminalExpresions.variables

import context.Context
import expresions.base.BinaryExpression
import expresions.terminalExpresions.VariablesExpression

class InitExpression: BinaryExpression() {
    override fun solve(context: Context) {
        val lValue = when(firstExpression) {
            is VariablesExpression -> firstExpression
            is CreateVariableExpression -> firstExpression?.solve(Context)
            else -> throw Exception("LValue of init(=) expression is not variable")
        } as VariablesExpression

        val rValue = secondExpression?.solve(Context)?: throw Exception("RValue of init(=) expression is incorrect")

        if(Context.variables.isInitialized(lValue.name) && rValue::class != lValue.solve(Context)::class) throw Exception("Type error")
        Context.variables.setValue(lValue.name, rValue)
    }

}