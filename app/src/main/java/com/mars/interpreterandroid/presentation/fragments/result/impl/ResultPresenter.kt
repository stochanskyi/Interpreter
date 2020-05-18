package com.mars.interpreterandroid.presentation.fragments.result.impl

import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.context.ContextStorage
import com.mars.interpreterandroid.data.execution.builder.AppBuilder
import com.mars.interpreterandroid.data.execution.optimization.optimize
import com.mars.interpreterandroid.presentation.base.mvp.BasePresenter
import com.mars.interpreterandroid.presentation.fragments.result.ResultContract

class ResultPresenter: BasePresenter<ResultContract.ViewContract>(),
    ResultContract.PresenterContract {

    private var code: String = ""
    private var optimize: Boolean = false

    override fun init(code: String, optimize: Boolean) {
        this.code = code
        this.optimize = optimize
    }

    override fun onStart() {
        ContextStorage.context = Context { view?.appendResult(it) }
        val tree =
            if(optimize) AppBuilder.build(code).optimize()
            else AppBuilder.build(code)
        tree.solve(ContextStorage.context)
    }
}