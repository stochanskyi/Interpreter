package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.loopExpressions

import com.flaringapp.treeview.ISplitNodeData
import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.ComplexExpression
import com.mars.interpreterandroid.data.expresions.base.BlockExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.data.expresions.base.UnitExpression
import com.mars.interpreterandroid.data.utils.run

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

    override fun getData(): String = "while"

    override fun childNodes(): MutableList<out ISplitNodeData> = mutableListOf(
        condition!!, ComplexExpression("block", block!!)
    )

}