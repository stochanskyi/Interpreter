package com.mars.interpreterandroid.presentation.fragments.tree

import com.mars.interpreterandroid.presentation.base.mvp.IBasePresenter
import com.mars.interpreterandroid.presentation.base.mvp.IBaseView

interface TreeContract {
    interface ViewContract: IBaseView

    interface PresenterContract: IBasePresenter<ViewContract> {

    }

}