package expresions.nonTerminalExpresions.comperationExpression

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression

class MoreEqualsExpression : BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(Context)
        val rValue = secondExpression?.solve(Context)

        return MoreExpression(firstExpression, secondExpression).solve(Context)!!
                || EqualsExpression(firstExpression, secondExpression).solve(Context)!!
    }
}