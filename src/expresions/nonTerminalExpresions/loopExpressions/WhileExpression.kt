package expresions.nonTerminalExpresions.loopExpressions

import context.Context
import expresions.base.BooleanExpression
import expresions.base.Expression
import expresions.base.UnitExpression
import utils.run

class WhileExpression: UnitExpression {
    var condition: BooleanExpression? = null
    var block: List<Expression>? = null

    override fun solve(context: Context) {
        condition?.let {
            while (condition!!.solve(context)) {
                block?.run(context) ?: throw Exception("While block cannot be null")
            }
        }?: throw Exception("Condition cannot be null")
    }
}