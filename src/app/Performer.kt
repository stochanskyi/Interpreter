package app

import context.Context
import execution.builder.AppBuilder
import execution.optimization.optimize
import utils.run

object Performer {

    fun perform(code: String){
        AppBuilder.build(code).optimize().run(Context)
    }
}