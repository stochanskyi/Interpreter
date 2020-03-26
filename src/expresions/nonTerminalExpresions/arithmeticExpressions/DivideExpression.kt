package expresions.nonTerminalExpresions.arithmeticExpressions

import context.Context
import expresions.base.BinaryExpression
import java.lang.Exception

class DivideExpression:  BinaryExpression() {

    override fun solve(context: Context): Any? {
        val leftExpression = firstExpression?.solve(Context)
        val rightExpression = secondExpression?.solve(Context)
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

}