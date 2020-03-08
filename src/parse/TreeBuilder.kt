package parse

import expresions.base.BinaryExpression
import expresions.base.Expression
import expresions.nonTerminalExpresions.ConstantNumberExpression
import expresions.nonTerminalExpresions.VariablesExpression
import expresions.terminalExpresions.arithmeticOperations.PlusExpression
import expresions.terminalExpresions.ioExpressions.PrintExpression

object TreeBuilder {

    fun buildTree(text: String) {

        val expressions = lineToExpressionsList(text)

        var treeHead: Expression<*>? = null

        for (expression in expressions) {
            treeHead = addToTree(treeHead, expression)
        }
    }

    private fun addToTree(treeHead: Expression<*>?, node: Expression<*>): Expression<*>? = when {
        treeHead == null -> node
        treeHead.priority > node.priority -> null
        treeHead.priority == node.priority -> null
        else -> addToTree(node, treeHead)
    }

    private fun checkChildesAndAdd(treeHead: Expression<*>?, node: Expression<*>): Expression<*> = when (treeHead) {
        is BinaryExpression<*, *, *> -> {
            if(treeHead.firstExpression == null) {
                treeHead.firstExpression = addToTree(treeHead.secondExpression, node)
                treeHead
            } else {
                treeHead.secondExpression = addToTree(treeHead.secondExpression, node)
                treeHead
            }

        }

    }

    private fun lineToExpressionsList(text: String): List<Expression<*>> {

        val expressionsListText = TextParser.parseBySpace(text)
        val expressionList = ArrayList<Expression<*>>()

        for (expressionText in expressionsListText) {
            var expression: Expression<*>
            if (text == "+") {

                expression = PlusExpression()
            } else if (text == "print") {

                expression = PlusExpression()
            } else if (text.toIntOrNull() != null) {

                expression = ConstantNumberExpression(text.toInt())
            } else {

                expression = VariablesExpression(text)
            }
            expressionList.add(expression)
        }

        return expressionList
    }


}