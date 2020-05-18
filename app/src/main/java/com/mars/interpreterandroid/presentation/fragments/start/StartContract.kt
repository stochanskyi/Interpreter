package com.mars.interpreterandroid.presentation.fragments.start

import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.mvp.IBasePresenter
import com.mars.interpreterandroid.presentation.base.mvp.IBaseView

interface StartContract {
    interface ViewContract: IBaseView {

    }

    interface PresenterContract: IBasePresenter<ViewContract> {
        fun init(listener: Navigation)

        fun updateCode(text: String)

        fun onBuildClick()
    }

}