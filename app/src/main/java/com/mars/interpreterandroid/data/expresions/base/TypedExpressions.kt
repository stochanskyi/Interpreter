package com.mars.interpreterandroid.data.expresions.base

import com.flaringapp.treeview.ISplitNodeData
import com.mars.interpreterandroid.data.context.Context

interface BooleanExpression: Expression, ISplitNodeData {
    override fun solve(context: Context): Boolean
}

interface IntegerExpression: Expression {
    override fun solve(context: Context): Int
}

interface UnitExpression: Expression {
    override fun solve(context: Context) {}
}

class EmptyExpression: UnitExpression {
    override fun getData(): String = "empty"
}