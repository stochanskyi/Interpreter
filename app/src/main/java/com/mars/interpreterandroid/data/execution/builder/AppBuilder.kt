package com.mars.interpreterandroid.data.execution.builder

import com.mars.interpreterandroid.data.execution.parsr.BlockParser
import com.mars.interpreterandroid.data.execution.parsr.enums.BlockType
import com.mars.interpreterandroid.data.expresions.ComplexExpression
import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import com.mars.interpreterandroid.data.utils.organizeCode
import com.mars.interpreterandroid.data.utils.trim

object AppBuilder {

    fun build(code: String): ComplexExpression {
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
        return ComplexExpression("App", codeTrees.toList().trim())
    }
}