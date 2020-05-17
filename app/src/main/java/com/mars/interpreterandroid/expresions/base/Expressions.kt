package com.mars.interpreterandroid.expresions.base

import com.mars.interpreterandroid.context.Context

interface Expression {
    fun solve(context: Context): Any
}

interface TerminalExpression: Expression

interface NonTerminalExpression: Expression

abstract class UnaryExpression: NonTerminalExpression {

    var firstExpression: Expression? = null

}

abstract class BinaryExpression: NonTerminalExpression {

    var firstExpression: Expression? = null
    var secondExpression: Expression? = null

}

interface BlockExpression: Expression