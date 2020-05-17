package com.mars.interpreterandroid.data.expresions.base

import com.flaringapp.treeview.ISplitNodeData
import com.mars.interpreterandroid.data.context.Context

interface Expression: ISplitNodeData {
    fun solve(context: Context): Any
    override fun childNodes(): MutableList<out ISplitNodeData> {
        return mutableListOf()
    }
}

interface TerminalExpression: Expression

interface NonTerminalExpression: Expression

abstract class UnaryExpression: NonTerminalExpression {

    var firstExpression: Expression? = null

    override fun childNodes(): MutableList<out ISplitNodeData> {
        return mutableListOf(firstExpression!!)
    }
}

abstract class BinaryExpression: NonTerminalExpression {

    var firstExpression: Expression? = null
    var secondExpression: Expression? = null

    override fun childNodes(): MutableList<out ISplitNodeData> {
        return mutableListOf(firstExpression!!, secondExpression!!)
    }
}

interface BlockExpression: Expression
