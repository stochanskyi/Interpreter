package com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BinaryExpression
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.Expression

class EqualsExpression: BinaryExpression, BooleanExpression {
    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean = firstExpression?.solve(context) == secondExpression?.solve(context)

    override fun getData(): String = "=="
}