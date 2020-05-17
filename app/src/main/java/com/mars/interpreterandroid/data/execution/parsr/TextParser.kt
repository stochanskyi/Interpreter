package com.mars.interpreterandroid.data.execution.parsr

object TextParser {
    fun parseByLines(text: String): List<String> = text.lines()

    fun parseBySpace(text: String): List<String> = text.split(' ')

    fun parseBySpace(lines: List<String>): List<List<String>> {

        val result = ArrayList<List<String>>()

        for(line in lines) {
            result.add(line.split(' '))
        }
        return result.toList()
    }


}