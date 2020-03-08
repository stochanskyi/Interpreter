package expresions.terminalExpresions.arithmeticOperations

import context.Context
import expresions.base.BinaryExpression
import expresions.base.Expression

class PlusExpression() : BinaryExpression<Int, Int, Int> {

    override val priority: Int = 2

    override var firstExpression: Expression<Int>? = null
    override var secondExpression: Expression<Int>? = null

    override fun solve(context: Context): Int = firstExpression?.solve(context)!! + secondExpression?.solve(context)!!



}
