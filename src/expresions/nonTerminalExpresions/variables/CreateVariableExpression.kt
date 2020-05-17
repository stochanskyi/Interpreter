package expresions.nonTerminalExpresions.variables

import context.Context
import expresions.base.UnaryExpression
import expresions.terminalExpresions.VariableExpression

class CreateVariableExpression: UnaryExpression() {

    override fun solve(context: Context): VariableExpression {
        val variable = firstExpression as? VariableExpression?: throw Exception("Attempt to create variable error")
        context.variables.createVar(variable.name)
        return variable
    }

}