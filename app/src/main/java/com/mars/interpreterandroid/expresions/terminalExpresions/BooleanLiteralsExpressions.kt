package com.mars.interpreterandroid.expresions.terminalExpresions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.BooleanExpression
import com.mars.interpreterandroid.expresions.base.TerminalExpression

class TrueLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = true
}

class FalseLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = false

}