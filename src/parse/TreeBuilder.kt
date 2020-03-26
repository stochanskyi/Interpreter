package parse

import expresions.base.BinaryExpression
import expresions.base.Expression
import expresions.base.TerminalExpression
import expresions.base.UnaryExpression
import expresions.nonTerminalExpresions.arithmeticExpressions.DivideExpression
import expresions.nonTerminalExpresions.arithmeticExpressions.MinusExpression
import expresions.nonTerminalExpresions.arithmeticExpressions.MultiplyExpression
import expresions.terminalExpresions.ConstantNumberExpression
import expresions.terminalExpresions.VariablesExpression
import expresions.nonTerminalExpresions.arithmeticExpressions.PlusExpression
import expresions.nonTerminalExpresions.comperationExpression.*
import expresions.nonTerminalExpresions.ioExpressions.PrintExpression
import expresions.nonTerminalExpresions.logicalExpressions.AndExpression
import expresions.nonTerminalExpresions.logicalExpressions.NotExpression
import expresions.nonTerminalExpresions.logicalExpressions.OrExpression

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
            expressionList.add(
                when(expressionText) {
                    "+" -> PlusExpression()
                    "-" -> MinusExpression()
                    "*" -> MultiplyExpression()
                    "/" -> DivideExpression()
                    "!" -> NotExpression()
                    "&&" -> AndExpression()
                    "||" -> OrExpression()
                    "==" -> EqualsExpression()
                    "!=" -> NotEqualsExpression()
                    ">" -> MoreExpression()
                    "<" -> LessExpression()
                    ">=" -> MoreEqualsExpression()
                    "<=" -> LessEqualsExpression()
                    "print" -> PrintExpression()
                    else -> when {
                        expressionText.toIntOrNull() != null -> ConstantNumberExpression(expressionText.toInt())

                        else -> VariablesExpression(text)
                    }
                }
            )
        }

        return expressionList
    }

    private val Expression.priority: Int
    get() = when(this) {
        is PrintExpression -> 20
        is OrExpression -> 9
        is AndExpression -> 8
        is EqualsExpression, is NotEqualsExpression -> 7
        is MoreExpression, is LessExpression, is MoreEqualsExpression, is LessEqualsExpression -> 6
        is DivideExpression, is MultiplyExpression -> 5
        is PlusExpression -> 4
        is NotExpression -> 3
        is TerminalExpression -> 0
        else-> throw Exception()
    }

}
