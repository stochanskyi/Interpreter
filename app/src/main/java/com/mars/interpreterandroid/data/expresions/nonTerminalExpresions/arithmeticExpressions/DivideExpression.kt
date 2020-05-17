package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import java.lang.Exception

class DivideExpression: BinaryExpression() {

    override fun solve(context: Context): Any {
        val leftExpression = firstExpression?.solve(context)
        val rightExpression = secondExpression?.solve(context)
        return when (leftExpression){
            is Int -> when(rightExpression) {
                is Int -> leftExpression / rightExpression
                is Float -> leftExpression / rightExpression
                is Double -> leftExpression / rightExpression
                else -> throw Exception("Not allowed type in divide(/) expression")
            }
            is Float -> when(rightExpression) {
                is Int -> leftExpression / rightExpression
                is Float -> leftExpression / rightExpression
                is Double -> leftExpression / rightExpression
                else -> throw Exception("Not allowed type in divide(/) expression")
            }
            is Double -> when(rightExpression) {
                is Int -> leftExpression / rightExpression
                is Float -> leftExpression / rightExpression
                is Double -> leftExpression / rightExpression
                else -> throw Exception("Not allowed type in divide(/) expression")
            }
            else -> throw Exception("Not allowed type in divide(/) expression")
        }

    }

    override fun getData(): String = "/"
}