package expresions.nonTerminalExpresions.variables

import context.Context
import expresions.base.BinaryExpression
import expresions.terminalExpresions.VariablesExpression

class InitExpression: BinaryExpression() {
    override fun solve(context: Context) {
        val lValue = firstExpression as? VariablesExpression?: throw Exception("lvalue of init(=) expression is not variable")
        val rValue = secondExpression?.solve(Context)?: throw Exception("rvalue of init(=) expression is incorrect")
        Context.variables.setValue(lValue.name, rValue)
    }

}