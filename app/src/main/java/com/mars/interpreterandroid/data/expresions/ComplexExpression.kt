package com.mars.interpreterandroid.data.expresions

import com.flaringapp.treeview.ISplitNodeData
import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.Expression

data class ComplexExpression(
    val name: String,
    val expressions: List<Expression>
) : Expression {
    override fun getData(): String = name

    override fun solve(context: Context) {
        expressions.forEach {
            it.solve(context)
        }
    }

    override fun childNodes(): MutableList<out ISplitNodeData> = expressions.toMutableList()
}