package execution.builder

import execution.parsr.BlockParser
import execution.parsr.enums.BlockType
import execution.parsr.models.BlockModel
import expresions.base.BooleanExpression
import expresions.base.Expression
import expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import expresions.nonTerminalExpresions.loopExpressions.WhileExpression
import utils.organizeCode
import java.lang.Exception
import java.lang.IllegalArgumentException

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