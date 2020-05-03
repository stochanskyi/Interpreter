package execution.optimization

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BlockExpression
import expresions.base.Expression
import expresions.base.UnaryExpression
import expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import expresions.nonTerminalExpresions.variables.CreateVariableExpression
import expresions.nonTerminalExpresions.variables.InitExpression
import expresions.terminalExpresions.VariableExpression
import java.lang.IllegalStateException

fun List<Expression>.optimize(): List<Expression> {
    val code = this.toMutableList()
    val variables = mutableMapOf<String, Expression>()
    return this.mapNotNull { it.optimize(variables) }
}

private fun Expression.optimize(vars: MutableMap<String, Expression>): Expression? {
    return when (this) {
        is InitExpression -> this.optimize(vars)
        is VariableExpression -> this.optimize(vars)
        is BinaryExpression -> this.optimize(vars)
        is UnaryExpression -> this.optimize(vars)
        else -> this
    }
}

private fun InitExpression.optimize(vars: MutableMap<String, Expression>): Expression? {
    vars.save(this.apply {
        secondExpression = secondExpression?.optimize(vars)
    })
    return null
}

private fun VariableExpression.optimize(vars: MutableMap<String, Expression>) =
    if (vars.containsKey(this.name)) vars[this.name]
    else this

private fun BinaryExpression.optimize(vars: MutableMap<String, Expression>) =
    this.apply {
        firstExpression = firstExpression?.optimize(vars)
        secondExpression = secondExpression?.optimize(vars)
    }

private fun UnaryExpression.optimize(vars: MutableMap<String, Expression>) =
    this.apply {
        firstExpression = firstExpression?.optimize(vars)
    }

private fun MutableMap<String, Expression>.save(expression: InitExpression) {
    val variableName = expression.getVarName()
    this[variableName] = expression.secondExpression as Expression
}

private fun MutableMap<String, Expression>.removeVar(varName: String) {
    Context.variables.apply {
        createVar(varName)
        this@removeVar[varName]?.solve(Context)?.let {
            setValue(varName, it)
        }
    }
    this.remove(varName)
}

private fun InitExpression.getVarName() = when (val expression = this.firstExpression) {
    is CreateVariableExpression -> (expression.firstExpression as VariableExpression).name
    is VariableExpression -> expression.name
    else -> throw IllegalStateException("Not supported type")
}