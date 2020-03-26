package expresions.nonTerminalExpresions.logicalExpressions

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression
import java.lang.Exception

class AndExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean? {
        val lValue = firstExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean first operator for and(&&) expression")
        val rValue = secondExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean second operator for and(&&) expression")

        return lValue && rValue
    }
}