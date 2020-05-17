package com.mars.interpreterandroid.data.expresions.terminalExpresions

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.expresions.base.TerminalExpression

class ConstantNumberExpression(private val number: Any): TerminalExpression {

    override fun solve(context: Context): Any = number

    override fun getData(): String = number.toString()

}