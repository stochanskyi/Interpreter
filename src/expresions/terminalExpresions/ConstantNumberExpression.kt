package expresions.terminalExpresions

import context.Context
import expresions.base.NonTerminalExpression
import expresions.base.TerminalExpression

class ConstantNumberExpression(private val number: Int): TerminalExpression {

    override fun solve(context: Context): Int = number
}