package com.mars.interpreterandroid.expresions.nonTerminalExpresions.conditionalExpressions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BlockExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.Expression
import com.mars.interpreterandroid.expresions.base.UnitExpression
import com.mars.interpreterandroid.utils.run

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