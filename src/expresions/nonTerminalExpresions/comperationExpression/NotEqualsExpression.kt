package expresions.nonTerminalExpresions.comperationExpression

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression

class NotEqualsExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean? = firstExpression?.solve(Context) != secondExpression?.solve(Context)

}