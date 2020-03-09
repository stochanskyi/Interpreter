package expresions.base

import context.Context
import java.security.AccessControlContext

interface Expression {
    fun solve(context: Context): Any?
    val priority: Int
}

interface TerminalExpression: Expression

interface NonTerminalExpression: Expression

interface UnaryExpression: TerminalExpression {

    var firstExpression: Expression?

}

interface BinaryExpression: TerminalExpression {

    var firstExpression: Expression?
    var secondExpression: Expression?

}

