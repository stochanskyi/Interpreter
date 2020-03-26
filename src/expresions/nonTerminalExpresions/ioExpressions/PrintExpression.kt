package expresions.nonTerminalExpresions.ioExpressions

import context.Context
import expresions.base.Expression
import expresions.base.UnaryExpression

class PrintExpression: UnaryExpression() {



    override fun solve(context: Context) {
        println(firstExpression?.solve(context))
    }


}