package com.mars.interpreterandroid.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.Expression
import java.lang.Exception

class MoreExpression: BinaryExpression, BooleanExpression {

    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(Context)
        val rValue = secondExpression?.solve(Context)

        return when (lValue) {
            is Int -> when (rValue) {
                is Int -> lValue > rValue
                is Float -> lValue > rValue
                is Double -> lValue > rValue
                else -> throw Exception("Not allowed type in more(>) expression")
            }
            is Float -> when (rValue) {
                is Int -> lValue > rValue
                is Float -> lValue > rValue
                is Double -> lValue > rValue
                else -> throw Exception("Not allowed type in more(>) expression")
            }
            is Double -> when (rValue) {
                is Int -> lValue > rValue
                is Float -> lValue > rValue
                is Double -> lValue > rValue
                else -> throw Exception("Not allowed type in more(>) expression")
            }
            else -> throw Exception("Not allowed type in more(>) expression")
        }
    }
}