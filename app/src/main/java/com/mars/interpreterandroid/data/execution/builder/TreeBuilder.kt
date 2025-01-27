package com.mars.interpreterandroid.data.execution.builder

import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions.DivideExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions.MinusExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions.MultiplyExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.ConstantNumberExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.VariableExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.arithmeticExpressions.PlusExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.comperationExpression.*
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.ioExpressions.PrintExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.logicalExpressions.AndExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.logicalExpressions.NotExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.logicalExpressions.OrExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.variables.CreateVariableExpression
import com.mars.interpreterandroid.data.expresions.nonTerminalExpresions.variables.InitExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.FalseLiteralExpression
import com.mars.interpreterandroid.data.expresions.terminalExpresions.TrueLiteralExpression
import com.mars.interpreterandroid.data.execution.parsr.TextParser
import com.mars.interpreterandroid.data.expresions.base.*

object TreeBuilder {

    fun buildTree(text: String): Expression {

        if (text.trim().isEmpty()) return EmptyExpression()
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
                treeHead.firstExpression =
                    addToTree(treeHead.secondExpression, node)
            } else {
                treeHead.secondExpression =
                    addToTree(treeHead.secondExpression, node)
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

        val expressionsListText = TextParser.parseBySpace(text).map { it.trim() }
        val expressionList = ArrayList<Expression>()

        for (expressionText in expressionsListText) {
            if(expressionText.trim().isEmpty()) continue
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
                    "=" -> InitExpression()
                    "print" -> PrintExpression()
                    "var" -> CreateVariableExpression()
                    "true" -> TrueLiteralExpression()
                    "false" -> FalseLiteralExpression()
                    else -> when {
                        expressionText.toIntOrNull() != null -> ConstantNumberExpression(expressionText.toInt())
                        else -> VariableExpression(expressionText)
                    }
                }
            )
        }

        return expressionList
    }

    private val Expression.priority: Int
    get() = when(this) {
        is InitExpression-> 20
        is PrintExpression -> 15
        is OrExpression -> 9
        is AndExpression -> 8
        is EqualsExpression, is NotEqualsExpression -> 7
        is MoreExpression, is LessExpression, is MoreEqualsExpression, is LessEqualsExpression -> 6
        is PlusExpression, is MinusExpression -> 5
        is DivideExpression, is MultiplyExpression -> 4
        is NotExpression -> 3
        is CreateVariableExpression -> 2
        is VariableExpression -> 1
        is TerminalExpression -> 0
        else-> throw Exception("Unknown expression")
    }

}
