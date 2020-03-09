package expresions.nonTerminalExpresions

import context.Context
import expresions.base.NonTerminalExpression
import java.security.AccessControlContext

class VariablesExpression(val name: String): NonTerminalExpression {

    override val priority: Int = 0

    override fun solve(context: Context): Int {
        return context.variables.getValue(name)!!
    }
}