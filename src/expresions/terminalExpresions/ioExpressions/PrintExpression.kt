package expresions.terminalExpresions.ioExpressions

import context.Context
import expresions.base.Expression
import expresions.base.UnaryExpression

class PrintExpression: UnaryExpression {

    override val priority: Int = 3

    override var firstExpression: Expression? = null

    override fun solve(context: Context) {
        println(firstExpression?.solve(context))
    }


}