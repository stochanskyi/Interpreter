package expresions.nonTerminalExpresions.logicalExpressions

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression
import expresions.base.UnaryExpression
import java.lang.Exception

class NotExpression: UnaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val value = firstExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean operator for not(!!) expression")
        return !value
    }

}