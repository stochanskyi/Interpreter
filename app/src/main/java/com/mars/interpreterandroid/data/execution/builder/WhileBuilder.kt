package com.mars.interpreterandroid.data.execution.builder

import com.mars.interpreterandroid.data.expresions.base.BooleanExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.loopExpressions.WhileExpression
import com.mars.interpreterandroid.data.utils.trim

object WhileBuilder {
    fun build(code: List<String>) = WhileExpression().apply {
        condition = buildCondition(code)
        block = buildBlock(code).trim()
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