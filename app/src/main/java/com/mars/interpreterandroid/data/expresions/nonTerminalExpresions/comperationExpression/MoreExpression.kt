package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.Expression
import java.lang.Exception

class MoreExpression: BinaryExpression, BooleanExpression {

    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean {
        val lValue = firstExpression?.solve(context)
        val rValue = secondExpression?.solve(context)

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

    override fun getData(): String = ">"
}