package execution.parsr.models

import execution.parsr.enums.BlockType

data class BlockModel(
    val code: List<String>,
    val type: BlockType
)