package com.mars.interpreterandroid.presentation.fragments.start.impl

import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.mvp.BasePresenter
import com.mars.interpreterandroid.presentation.fragments.start.StartContract

class StartPresenter: BasePresenter<StartContract.ViewContract>(),
    StartContract.PresenterContract{
    private var code = ""

    private lateinit var listener: Navigation

    override fun init(listener: Navigation) {
        this.listener = listener
    }

    override fun updateCode(text: String) {
        code = text
    }

    override fun onBuildClick() {
        listener.openTreeScreen(code)
    }
}
