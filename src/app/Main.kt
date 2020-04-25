package app

import java.io.File
import java.nio.charset.CharsetEncoder

fun main() {
    val code = readFile("D:\\code.txt")
    Performer.perform(code)
}

private fun readFile(fileName: String) = File(fileName).readText(Charsets.UTF_8)