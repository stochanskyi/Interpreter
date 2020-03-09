package expresions.terminalExpresions.arithmeticOperations

import context.Context
import expresions.base.BinaryExpression
import expresions.base.Expression

class PlusExpression() : BinaryExpression {

    override val priority: Int = 2

    override var firstExpression: Expression? = null
    override var secondExpression: Expression? = null

    override fun solve(context: Context): Int = firstExpression?.solve(context)!! as Int + secondExpression?.solve(context)!! as Int


}
