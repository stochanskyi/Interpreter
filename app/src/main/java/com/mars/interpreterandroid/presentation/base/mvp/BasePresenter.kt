package com.mars.interpreterandroid.presentation.base.mvp

abstract class BasePresenter<V : IBaseView?> : IBasePresenter<V> {
    protected var view: V? = null
    override fun attachView(view: V) {
        this.view = view
    }

    override fun release() {
        view = null
    }

}