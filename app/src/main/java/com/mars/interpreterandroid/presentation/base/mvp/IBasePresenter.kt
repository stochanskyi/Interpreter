package com.mars.interpreterandroid.presentation.base.mvp

interface IBasePresenter<V : IBaseView?> {
    fun attachView(view: V)
    fun onStart() {}
    fun release()
}
