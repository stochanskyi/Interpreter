package com.mars.interpreterandroid.expresions.nonTerminalExpresions.comperationExpression

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BinaryExpression
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.Expression

class EqualsExpression: BinaryExpression, BooleanExpression {
    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean = firstExpression?.solve(Context) == secondExpression?.solve(Context)

}