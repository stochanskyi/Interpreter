package expresions.terminalExpresions

import context.Context
import expresions.base.NonTerminalExpression
import expresions.base.TerminalExpression
import java.security.AccessControlContext

class VariablesExpression(val name: String): TerminalExpression {

    override fun solve(context: Context): Any {
        return context.variables.getValue(name)!!
    }
}