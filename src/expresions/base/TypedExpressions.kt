package expresions.base

import context.Context

interface BooleanExpression: Expression {
    override fun solve(context: Context): Boolean
}

interface IntegerExpression: Expression {
    override fun solve(context: Context): Int
}

interface UnitExpression: Expression {
    override fun solve(context: Context) {}
}

class EmptyExpression: UnitExpression