package com.mars.interpreterandroid.execution.builder

import com.mars.interpreterandroid.execution.parsr.BlockParser
import com.mars.interpreterandroid.execution.parsr.enums.BlockType
import com.mars.interpreterandroid.expresions.base.Expression
import com.mars.interpreterandroid.expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import com.mars.interpreterandroid.utils.organizeCode

object AppBuilder {

    fun build(code: String): List<Expression> {
        val blocks = BlockParser.parse(organizeCode(code))

        val codeTrees = mutableListOf<Expression>()
        for (block in blocks) {
            when (block.type) {
                BlockType.SIMPLE -> codeTrees += TreeBuilder.buildTree(block.code.first())
                BlockType.IF -> codeTrees += IfElseBuilder.buildIf(block.code)
                BlockType.ELSE -> IfElseBuilder.appendElse(block.code, codeTrees.last() as IfElseExpression)
                BlockType.WHILE -> codeTrees += WhileBuilder.build(block.code)
            }
        }
        return codeTrees.toList()
    }
}