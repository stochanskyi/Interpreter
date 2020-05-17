package com.mars.interpreterandroid.data.execution.parsr.models

import com.mars.interpreterandroid.data.execution.parsr.enums.BlockType

data class BlockModel(
    val code: List<String>,
    val type: BlockType
)