package execution.optimization

import expresions.base.BinaryExpression
import expresions.base.Expression
import expresions.base.UnaryExpression
import expresions.nonTerminalExpresions.variables.CreateVariableExpression
import expresions.nonTerminalExpresions.variables.InitExpression
import expresions.terminalExpresions.VariableExpression
import java.lang.IllegalStateException

fun List<Expression>.optimize() {
    val code = this.toMutableList()
    val variables = mutableMapOf<String, Expression>()
    for (expression in code) {
        expression.optimize(variables)
    }
}

private fun Expression.optimize(vars: MutableMap<String, Expression>) {
     when (this) {
        is InitExpression -> {
            this.secondExpression?.optimize(vars)
            vars.save(this)
        }
        is BinaryExpression -> this.optimize(vars)
        is UnaryExpression -> this.optimize(vars)
    }
}

private fun BinaryExpression.optimize(vars: MutableMap<String, Expression>) {
    (this.firstExpression as? VariableExpression)?.run {
        this@optimize.firstExpression = vars[this.name]
    }?:this.firstExpression?.optimize(vars)
    (this.secondExpression as? VariableExpression)?.run {
        this@optimize.secondExpression = vars[this.name]
    }?:this.secondExpression?.optimize(vars)
}

private fun UnaryExpression.optimize(vars: MutableMap<String, Expression>) {
    (this.firstExpression as? VariableExpression)?.run {
        this@optimize.firstExpression = vars[this.name]
    }?:this.optimize(vars)
}

private fun MutableMap<String, Expression>.save(expression: InitExpression) {
    val variableName = expression.getVarName()
    this[variableName] = expression.secondExpression as Expression
}

private fun InitExpression.getVarName() = when (val expression = this.firstExpression) {
    is CreateVariableExpression -> (expression.firstExpression as VariableExpression).name
    is VariableExpression -> expression.name
    else -> throw IllegalStateException("Not supported type")
}