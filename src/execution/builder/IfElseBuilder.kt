package execution.builder

import expresions.base.BooleanExpression
import expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression

object IfElseBuilder {
    fun buildIf(code: List<String>) = IfElseExpression().apply {
        condition = buildCondition(code)
        ifBlock = buildBlock(code)
    }

    fun appendElse(code: List<String>, expression: IfElseExpression) {
        expression.elseBlock = buildBlock(code)
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