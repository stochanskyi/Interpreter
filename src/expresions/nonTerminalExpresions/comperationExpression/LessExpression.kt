package expresions.nonTerminalExpresions.comperationExpression

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression
import expresions.base.Expression
import java.lang.Exception

class LessExpression : BinaryExpression, BooleanExpression {

    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean? {
        val lValue = firstExpression?.solve(Context)
        val rValue = secondExpression?.solve(Context)

        return when (lValue) {
            is Int -> when (rValue) {
                is Int -> lValue < rValue
                is Float -> lValue < rValue
                is Double -> lValue < rValue
                else -> throw Exception("Not allowed type in less(<) expression")
            }
            is Float -> when (rValue) {
                is Int -> lValue < rValue
                is Float -> lValue < rValue
                is Double -> lValue < rValue
                else -> throw Exception("Not allowed type in less(<) expression")
            }
            is Double -> when (rValue) {
                is Int -> lValue < rValue
                is Float -> lValue < rValue
                is Double -> lValue < rValue
                else -> throw Exception("Not allowed type in less(<) expression")
            }
            else -> throw Exception("Not allowed type in less(<) expression")
        }
    }
}