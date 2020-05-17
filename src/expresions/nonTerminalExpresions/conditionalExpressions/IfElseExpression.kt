package expresions.nonTerminalExpresions.conditionalExpressions

import context.Context
import expresions.base.BlockExpression
import expresions.base.BooleanExpression
import expresions.base.Expression
import expresions.base.UnitExpression
import utils.run

class IfElseExpression: UnitExpression, BlockExpression{
    var condition: BooleanExpression? = null
    var ifBlock: List<Expression>? = null
    var elseBlock: List<Expression>? = null

    override fun solve(context: Context) {
        condition?.let {
            if(condition!!.solve(context)) {
                ifBlock?.run(context)
            } else {
                elseBlock?.run(context)
            }
        }
    }

}