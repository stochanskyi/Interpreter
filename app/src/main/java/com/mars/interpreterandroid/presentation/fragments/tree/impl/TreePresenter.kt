package com.mars.interpreterandroid.presentation.fragments.tree.impl

import com.mars.interpreterandroid.data.execution.builder.AppBuilder
import com.mars.interpreterandroid.data.execution.optimization.optimize
import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.mvp.BasePresenter
import com.mars.interpreterandroid.presentation.fragments.tree.TreeContract

class TreePresenter : BasePresenter<TreeContract.ViewContract>(),
    TreeContract.PresenterContract {

    private lateinit var code: String

    private lateinit var listener: Navigation

    private lateinit var tree: Expression

    private var optimize: Boolean = false

    override fun init(code: String, optimize: Boolean, listener: Navigation) {
        this.code = code
        this.optimize = optimize
        this.listener = listener
    }

    override fun onStart() {
        val tree =
            if (optimize) AppBuilder.build(code).optimize()
            else AppBuilder.build(code)
        view?.updateTree(tree)
    }

    override fun onOptimizeClick() {
        listener.openOptimisedScreen(code)
    }

    override fun onExecuteClick() {
        listener.openResultScreen(code)
    }
}