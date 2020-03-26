package expresions.nonTerminalExpresions.logicalExpressions

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression
import java.lang.Exception

class OrExpression: BinaryExpression(), BooleanExpression {
    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean first operator for or(||) expression")
        val rValue = secondExpression?.solve(Context) as? Boolean?: throw Exception("Not boolean second operator for or(||) expression")

        return lValue || rValue
    }
}