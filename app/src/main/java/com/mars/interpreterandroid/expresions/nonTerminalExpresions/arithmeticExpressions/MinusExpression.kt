package com.mars.interpreterandroid.expresions.nonTerminalExpresions.arithmeticExpressions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import java.lang.Exception

class MinusExpression: BinaryExpression() {
    override fun solve(context: Context): Any {
        val leftExpression = firstExpression?.solve(Context)
        val rightExpression = secondExpression?.solve(Context)
        return when (leftExpression){
            is Int -> when(rightExpression) {
                is Int -> leftExpression - rightExpression
                is Float -> leftExpression - rightExpression
                is Double -> leftExpression - rightExpression
                else -> throw Exception("Not allowed type in minus(-) expression")
            }
            is Float -> when(rightExpression) {
                is Int -> leftExpression - rightExpression
                is Float -> leftExpression - rightExpression
                is Double -> leftExpression - rightExpression
                else -> throw Exception("Not allowed type in minus(-) expression")
            }
            is Double -> when(rightExpression) {
                is Int -> leftExpression - rightExpression
                is Float -> leftExpression - rightExpression
                is Double -> leftExpression - rightExpression
                else -> throw Exception("Not allowed type in minus(-) expression")
            }
            else -> throw Exception("Not allowed type in minus(-) expression")
        }
    }


}