package app

import context.Context
import parse.TextParser
import parse.TreeBuilder

object Performer {

    fun perform(text: String){
        val lines = TextParser.parseByLines(text)
        for (line in lines) {
            TreeBuilder.buildTree(line).solve(Context)
        }

    }
}