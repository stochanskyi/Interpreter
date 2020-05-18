package com.mars.interpreterandroid.presentation.base.mvp

import android.view.View

interface IBaseView {
    fun createPresenterInstance()
    fun initPresenter()
    fun initViews(view: View?)
}