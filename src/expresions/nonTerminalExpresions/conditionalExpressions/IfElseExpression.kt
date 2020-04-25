package expresions.nonTerminalExpresions.conditionalExpressions

import context.Context
import expresions.base.BooleanExpression
import expresions.base.Expression
import expresions.base.UnitExpression
import utils.solve

class IfElseExpression: UnitExpression{

    var condition: BooleanExpression? = null
    var ifBlock: List<Expression>? = null
    var elseBlock: List<Expression>? = null

    override fun solve(context: Context) {
        condition?.let {
            if(condition!!.solve(context)) {
                ifBlock?.solve(context)
            } else {
                elseBlock?.solve(context)
            }
        }?: throw Exception(message = "Condition cannot be null")
    }

}