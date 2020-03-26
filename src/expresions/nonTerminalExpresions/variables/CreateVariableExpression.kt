package expresions.nonTerminalExpresions.variables

import context.Context
import expresions.base.UnaryExpression
import expresions.terminalExpresions.VariablesExpression

class CreateVariableExpression: UnaryExpression() {

    override fun solve(context: Context): VariablesExpression {
        val variable = firstExpression as? VariablesExpression?: throw Exception("Attempt to create variable error")
        context.variables.createVar(variable.name)
        return variable
    }

}