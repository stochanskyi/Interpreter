package com.mars.interpreterandroid.expresions.terminalExpresions

import com.mars.interpreterandroid.context.Context
import com.mars.interpreterandroid.expresions.base.TerminalExpression

class ConstantNumberExpression(private val number: Any): TerminalExpression {

    override fun solve(context: Context): Any = number
}