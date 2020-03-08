package expresions.nonTerminalExpresions

import context.Context
import expresions.base.NonTerminalExpression

class ConstantNumberExpression(private val number: Int): NonTerminalExpression {
    override val priority: Int = 0

    override fun solve(context: Context): Int = number
}