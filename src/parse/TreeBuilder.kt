package parse

import expresions.base.BinaryExpression
import expresions.base.Expression
import expresions.base.TerminalExpression
import expresions.base.UnaryExpression
import expresions.terminalExpresions.ConstantNumberExpression
import expresions.terminalExpresions.VariablesExpression
import expresions.nonTerminalExpresions.arithmeticExpressions.PlusExpression
import expresions.nonTerminalExpresions.ioExpressions.PrintExpression

object TreeBuilder {

    fun buildTree(text: String): Expression {

        val expressions = lineToExpressionsList(text)

        var treeHead: Expression? = null

        for (expression in expressions) {
            treeHead = addToTree(treeHead, expression)
        }

        return treeHead!!
    }

    private fun addToTree(treeHead: Expression?, node: Expression): Expression = when {
        treeHead == null -> node
        treeHead.priority > node.priority -> checkChildesAndAdd(treeHead, node)
        treeHead.priority == node.priority -> checkChildesAndAdd(node, treeHead)
        else -> addToTree(node, treeHead)
    }

    private fun checkChildesAndAdd(treeHead: Expression?, node: Expression): Expression = when (treeHead) {
        is BinaryExpression -> {
            if(treeHead.firstExpression == null) {
                treeHead.firstExpression = addToTree(treeHead.secondExpression, node)
            } else {
                treeHead.secondExpression = addToTree(treeHead.secondExpression, node)
            }
            treeHead
        }
        is UnaryExpression -> {
            treeHead.firstExpression = addToTree(treeHead.firstExpression, node)
            treeHead
        }

        else -> addToTree(node, treeHead!!)


    }

    private fun lineToExpressionsList(text: String): List<Expression> {

        val expressionsListText = TextParser.parseBySpace(text)
        val expressionList = ArrayList<Expression>()

        for (expressionText in expressionsListText) {
            var expression: Expression
            when {
                expressionText == "+" -> {

                    expression = PlusExpression()
                }
                expressionText == "print" -> {

                    expression = PrintExpression()
                }
                expressionText.toIntOrNull() != null -> {

                    expression =
                        ConstantNumberExpression(expressionText.toInt())
                }
                else -> {

                    expression = VariablesExpression(text)
                }
            }
            expressionList.add(expression)
        }

        return expressionList
    }

    private val Expression.priority: Int
    get() = when(this) {
        is PrintExpression -> 20
        //AssignExpression 18
        is PlusExpression -> 16
        is TerminalExpression -> 0
        else-> throw Exception()
    }

}
