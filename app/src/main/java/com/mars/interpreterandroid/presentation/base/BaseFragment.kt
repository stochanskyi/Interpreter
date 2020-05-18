package com.mars.interpreterandroid.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import com.mars.interpreterandroid.presentation.base.mvp.IBasePresenter
import com.mars.interpreterandroid.presentation.base.mvp.IBaseView

abstract class BaseFragment<P : IBasePresenter<*>?> :
    Fragment, IBaseView {

    protected var presenter: P? = null

    constructor(): super()

    constructor(resId: Int) : super(resId)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        createPresenterInstance()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnTouchListener { _: View?, _: MotionEvent? -> true }
        initViews(view)
        initPresenter()
        presenter?.onStart()
    }
}