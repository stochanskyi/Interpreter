package expresions.base

import context.Context
import java.security.AccessControlContext

interface Expression<T> {
    fun solve(context: Context): T
    val priority: Int
}

interface TerminalExpression<T>: Expression<T>

interface NonTerminalExpression: Expression<Int>

interface UnaryExpression<T>: TerminalExpression<T> {

    var firstExpression: Expression<*>?

}

interface BinaryExpression<T, F, S>: TerminalExpression<T> {

    var firstExpression: Expression<F>?
    var secondExpression: Expression<S>?

}

