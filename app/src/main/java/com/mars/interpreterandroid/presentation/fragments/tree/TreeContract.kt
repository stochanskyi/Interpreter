package com.mars.interpreterandroid.presentation.fragments.tree

import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.mvp.IBasePresenter
import com.mars.interpreterandroid.presentation.base.mvp.IBaseView

interface TreeContract {
    interface ViewContract : IBaseView {
        fun updateTree(expression: Expression)
    }

    interface PresenterContract : IBasePresenter<ViewContract> {
        fun init(code: String, optimize: Boolean,  listener: Navigation)
        fun onOptimizeClick()
        fun onExecuteClick()
    }

}