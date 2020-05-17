package com.mars.interpreterandroid.data.context

class Context(
    val outputBlock: (String) -> Unit
) {
    val variables = VariablesImpl()
}