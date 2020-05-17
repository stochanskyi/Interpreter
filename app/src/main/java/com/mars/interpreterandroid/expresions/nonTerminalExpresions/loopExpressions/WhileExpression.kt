package com.mars.interpreterandroid.expresions.nonTerminalExpresions.loopExpressions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BlockExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.Expression
import com.mars.interpreterandroid.expresions.base.UnitExpression
import com.mars.interpreterandroid.utils.run

class WhileExpression: UnitExpression, BlockExpression {
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