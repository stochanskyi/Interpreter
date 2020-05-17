package com.mars.interpreterandroid.data.execution.builder

import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import com.mars.interpreterandroid.data.utils.trim

object IfElseBuilder {
    fun buildIf(code: List<String>) = IfElseExpression().apply {
        condition = buildCondition(code)
        ifBlock = buildBlock(code).trim()
    }

    fun appendElse(code: List<String>, expression: IfElseExpression) {
        expression.elseBlock = buildBlock(code).trim()
    }

    private fun buildCondition(code: List<String>) = TreeBuilder.buildTree(
            code.first().let { line ->
                line.substring(
                    line.indexOfFirst { it == '(' } + 1,
                    line.indexOfLast { it == ')' }
                )
            }
        ) as BooleanExpression

    private fun buildBlock(code: List<String>) = code.let { codeList ->
        codeList.subList(
            codeList.indexOfFirst { it == "{" } + 1,
            codeList.indexOfLast { it == "}" })
    }.map { TreeBuilder.buildTree(it) }

}