package execution.optimization

import context.Context
import expresions.base.*
import expresions.nonTerminalExpresions.conditionalExpressions.IfElseExpression
import expresions.nonTerminalExpresions.loopExpressions.WhileExpression
import expresions.nonTerminalExpresions.variables.CreateVariableExpression
import expresions.nonTerminalExpresions.variables.InitExpression
import expresions.terminalExpresions.VariableExpression
import java.lang.IllegalStateException

fun List<Expression>.optimize(): List<Expression> {
    val variables = mutableMapOf<String, Expression>()
    return this.mapNotNull { it.optimize(variables, true) }
}

private fun Expression.optimize(vars: MutableMap<String, Expression>, useVarsRemoving: Boolean): Expression? {
    return when (this) {
        is InitExpression -> this.optimize(vars, useVarsRemoving)
        is VariableExpression -> this.optimize(vars)
        is BlockExpression -> this.removeVarsIfUses(vars)
        is BinaryExpression -> this.optimize(vars, useVarsRemoving)
        is UnaryExpression -> this.optimize(vars, useVarsRemoving)
        else -> this
    }
}

private fun InitExpression.optimize(vars: MutableMap<String, Expression>, useVarsRemoving: Boolean): Expression? {
    secondExpression = secondExpression?.optimize(vars, useVarsRemoving)
    return if (useVarsRemoving) {
        vars.save(this)
        null
    } else this
}

private fun VariableExpression.optimize(vars: MutableMap<String, Expression>) =
    if (vars.containsKey(this.name)) vars[this.name]
    else this

private fun BinaryExpression.optimize(vars: MutableMap<String, Expression>, useVarsRemoving: Boolean) =
    this.apply {
        firstExpression = firstExpression?.optimize(vars, useVarsRemoving)
        secondExpression = secondExpression?.optimize(vars, useVarsRemoving)
    }

private fun UnaryExpression.optimize(vars: MutableMap<String, Expression>, useVarsRemoving: Boolean) =
    this.apply {
        firstExpression = firstExpression?.optimize(vars, useVarsRemoving)
    }

private fun MutableMap<String, Expression>.save(expression: InitExpression) {
    val variableName = expression.getVarName()
    this[variableName] = expression.secondExpression as Expression
}

private fun MutableMap<String, Expression>.removeVar(varName: String) {
    if (this.containsKey(varName).not()) return
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

private fun BlockExpression.removeVarsIfUses(vars: MutableMap<String, Expression>): Expression {
    when (this) {
        is IfElseExpression -> {
            ifBlock?.removeVarsIfUses(vars)
            elseBlock?.removeVarsIfUses(vars)
//            this.condition?.removeVarsIfUses(vars)
            ifBlock = ifBlock?.mapNotNull { it.optimize(vars, false) }
            elseBlock = elseBlock?.mapNotNull { it.optimize(vars, false) }
        }
        is WhileExpression -> {
            block?.removeVarsIfUses(vars)
//            condition?.removeVarsIfUses(vars)
            block = block?.mapNotNull { it.optimize(vars, false) }
        }
    }
    return this
}

private fun List<Expression>.removeVarsIfUses(vars: MutableMap<String, Expression>) {
    for (expression in this) {
        when (expression) {
            is InitExpression -> vars.removeVar(expression.getVarName())
        }
    }
}

//private fun Expression.removeVarsIfUses(vars: MutableMap<String, Expression>) {
//    when (this) {
//        is VariableExpression -> vars.removeVar(this.name)
//        is UnaryExpression -> this.firstExpression?.removeVarsIfUses(vars)
//        is BinaryExpression -> {
//            firstExpression?.removeVarsIfUses(vars)
//            secondExpression?.removeVarsIfUses(vars)
//        }
//    }
//}