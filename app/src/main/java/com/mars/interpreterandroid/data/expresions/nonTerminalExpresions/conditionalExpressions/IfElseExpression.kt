package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.conditionalExpressions

import com.flaringapp.treeview.ISplitNodeData
import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.ComplexExpression
import com.mars.interpreterandroid.data.expresions.base.BlockExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.data.expresions.base.UnitExpression
import com.mars.interpreterandroid.data.utils.run
import java.util.concurrent.CompletionException

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

    override fun getData(): String = "if/else"

    override fun childNodes(): MutableList<out ISplitNodeData> {
        return mutableListOf(condition!!,
            ComplexExpression("if", ifBlock!!),
            ComplexExpression("else", elseBlock!!))
    }
}