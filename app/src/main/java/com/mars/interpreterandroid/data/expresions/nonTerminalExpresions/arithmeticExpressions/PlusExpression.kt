package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import java.lang.Exception

class PlusExpression : BinaryExpression() {

    override fun solve(context: Context): Any {
        val leftExpression = firstExpression?.solve(context)
        val rightExpression = secondExpression?.solve(context)
        return when (leftExpression){
            is Int -> when(rightExpression) {
                is Int -> leftExpression + rightExpression
                is Float -> leftExpression + rightExpression
                is Double -> leftExpression + rightExpression
                else -> throw Exception("Not allowed type in add(+) expression")
            }
            is Float -> when(rightExpression) {
                is Int -> leftExpression + rightExpression
                is Float -> leftExpression + rightExpression
                is Double -> leftExpression + rightExpression
                else -> throw Exception("Not allowed type in add(+) expression")
            }
            is Double -> when(rightExpression) {
                is Int -> leftExpression + rightExpression
                is Float -> leftExpression + rightExpression
                is Double -> leftExpression + rightExpression
                else -> throw Exception("Not allowed type in add(+) expression")
            }
            else -> throw Exception("Not allowed type in add(+) expression")
        }
    }

    override fun getData(): String = "+"
}
