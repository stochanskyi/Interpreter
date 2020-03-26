package expresions.terminalExpresions

import context.Context
import expresions.base.BooleanExpression
import expresions.base.TerminalExpression

class TrueLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = true
}

class FalseLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = false

}