package com.mars.interpreterandroid.presentation.fragments.start.impl

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.mars.interpreterandroid.R
import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.BaseFragment
import com.mars.interpreterandroid.presentation.fragments.start.StartContract
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : BaseFragment<StartContract.PresenterContract>(R.layout.fragment_start),
    StartContract.ViewContract {

    companion object {
        fun newInstance() = StartFragment().apply {
            arguments = Bundle()
        }
    }

    override fun createPresenterInstance() {
        presenter = StartPresenter()
    }

    override fun initPresenter() {
        presenter?.attachView(this)
        presenter?.init(activity as Navigation)
    }

    override fun initViews(view: View?) {
        codeInput.doAfterTextChanged { presenter?.updateCode(it.toString()) }
        buttonBuild.setOnClickListener { presenter?.onBuildClick() }
    }

}