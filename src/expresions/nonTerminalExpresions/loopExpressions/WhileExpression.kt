package expresions.nonTerminalExpresions.loopExpressions

import context.Context
import expresions.base.BooleanExpression
import expresions.base.Expression
import expresions.base.UnitExpression
import utils.solve

class WhileExpression: UnitExpression {
    var condition: BooleanExpression? = null
    var block: List<Expression>? = null

    override fun solve(context: Context) {
        condition?.let {
            while (condition!!.solve(context)) {
                block?.solve(context) ?: throw Exception("While block cannot be null")
            }
        }?: throw Exception(message = "Condition cannot be null")
    }
}