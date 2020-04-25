package execution.parsr

import execution.parsr.enums.BlockType
import execution.parsr.models.BlockModel

object BlockParser {
    /*fun parse(code: String): List<BlockModel> {
        val blocks = mutableListOf<BlockModel>()
        val lines = code.lines()

        var i = 0
        while (i < lines.size) {
            if(lines[i].isEmpty()) {
                i++
                continue
            }
            when {
                lines[i].startsWith("if") -> {
                    val endIndex = lines.subList(i, lines.lastIndex).indexOfFirst { it.startsWith("}") }
                    blocks += BlockModel(lines.subList(i, endIndex + 1), BlockType.IF).also { i = endIndex + 1 }
                }
                lines[i].startsWith("else") -> {
                    val endIndex = lines.subList(i, lines.lastIndex).indexOfFirst { it.startsWith("}") }
                    blocks += BlockModel(lines.subList(i, endIndex + 1), BlockType.ELSE).also { i = endIndex + 1 }
                }
                lines[i].startsWith("while") -> {

                }
                else -> blocks += BlockModel(listOf(lines[i]), BlockType.SIMPLE).also { i++ }
            }
        }

        return blocks.toList()
    }*/
    fun parse(code: String): List<BlockModel> {
        val blocks = mutableListOf<BlockModel>()
        var lines = code.lines()

        while (lines.isNotEmpty()) {
            val line = lines.first()
            if(line.trim().isEmpty()) {
                lines = lines.subList(1, lines.lastIndex + 1)
                continue
            }
            var cuttingIndex = 0
            when {
                line.startsWith("if") -> {
                    val endIndex = lines.indexOfFirst { it.startsWith("}") }
                    blocks += BlockModel(lines.subList(0, endIndex + 1), BlockType.IF).also { cuttingIndex = endIndex + 1 }
                }
                line.startsWith("else") -> {
                    val endIndex = lines.indexOfFirst { it.startsWith("}") }
                    blocks += BlockModel(lines.subList(0, endIndex + 1), BlockType.ELSE).also { cuttingIndex = endIndex + 1 }
                }
                line.startsWith("while") -> {

                }
                else -> blocks += BlockModel(listOf(line), BlockType.SIMPLE).also { cuttingIndex++ }
            }
            lines = lines.subList(cuttingIndex, lines.lastIndex + 1)
        }

        return blocks.toList()
    }


}

