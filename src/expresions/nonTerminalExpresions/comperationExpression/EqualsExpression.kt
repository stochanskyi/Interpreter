package expresions.nonTerminalExpresions.comperationExpression

import context.Context
import expresions.base.BinaryExpression
import expresions.base.BooleanExpression
import expresions.base.Expression

class EqualsExpression: BinaryExpression, BooleanExpression {
    constructor(firstExpression: Expression?, secondExpression: Expression?) {
        this.firstExpression = firstExpression
        this.secondExpression = secondExpression
    }

    constructor()

    override fun solve(context: Context): Boolean? = firstExpression?.solve(Context) == secondExpression?.solve(Context)

}