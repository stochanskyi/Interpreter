package com.mars.interpreterandroid.presentation.fragments.result

import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.mvp.IBasePresenter
import com.mars.interpreterandroid.presentation.base.mvp.IBaseView

interface ResultContract {
    interface ViewContract : IBaseView {
        fun appendResult(result: String)
    }

    interface PresenterContract : IBasePresenter<ViewContract> {
        fun init(code: String, optimize: Boolean)
    }

}