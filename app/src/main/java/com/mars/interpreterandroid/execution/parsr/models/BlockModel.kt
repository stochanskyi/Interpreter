package com.mars.interpreterandroid.execution.parsr.models

import com.mars.interpreterandroid.execution.parsr.enums.BlockType

data class BlockModel(
    val code: List<String>,
    val type: BlockType
)