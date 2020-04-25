package app

import context.Context
import execution.builder.AppBuilder
import utils.run

object Performer {

    fun perform(code: String){
        AppBuilder.build(code).run(Context)
    }
}