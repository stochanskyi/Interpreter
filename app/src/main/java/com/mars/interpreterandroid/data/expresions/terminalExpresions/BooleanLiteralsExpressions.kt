package com.mars.interpreterandroid.data.expresions.terminalExpresions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.base.TerminalExpression

class TrueLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = true

    override fun getData(): String = "true"
}

class FalseLiteralExpression(): TerminalExpression, BooleanExpression {
    override fun solve(context: Context): Boolean = false

    override fun getData(): String = "false"
}