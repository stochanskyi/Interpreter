package com.mars.interpreterandroid.presentation.fragments.result.impl

import android.os.Bundle
import android.view.View
import com.mars.interpreterandroid.R
import com.mars.interpreterandroid.presentation.base.BaseFragment
import com.mars.interpreterandroid.presentation.fragments.result.ResultContract
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment: BaseFragment<ResultContract.PresenterContract>(R.layout.fragment_result),
    ResultContract.ViewContract {

    companion object {
        private const val KEY_CODE= "key_code"
        private const val KEY_OPTIMIZE = "key_optimize"

        fun newInstance(code: String, optimize: Boolean) = ResultFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_CODE, code)
                putBoolean(KEY_OPTIMIZE, optimize)
            }
        }
    }

    override fun createPresenterInstance() {
        presenter = ResultPresenter()
    }

    override fun initPresenter() {
        presenter?.attachView(this)
        val code = arguments!!.getString(KEY_CODE)!!
        val optimize = arguments!!.getBoolean(KEY_OPTIMIZE)
        presenter?.init(code, optimize)
    }

    override fun initViews(view: View?) {
    }

    override fun appendResult(result: String) {
        textResult.append("$result\n")
    }
}