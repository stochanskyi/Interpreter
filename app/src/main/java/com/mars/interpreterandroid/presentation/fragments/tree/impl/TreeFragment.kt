package com.mars.interpreterandroid.presentation.fragments.tree.impl

import android.os.Bundle
import android.view.View
import com.mars.interpreterandroid.R
import com.mars.interpreterandroid.data.expresions.base.Expression
import com.mars.interpreterandroid.presentation.activities.main.Navigation
import com.mars.interpreterandroid.presentation.base.BaseFragment
import com.mars.interpreterandroid.presentation.fragments.tree.TreeContract
import kotlinx.android.synthetic.main.fragment_tree.*

class TreeFragment: BaseFragment<TreeContract.PresenterContract>(R.layout.fragment_tree),
    TreeContract.ViewContract{
    companion object {
        private const val KEY_CODE= "key_code"
        private const val KEY_OPTIMIZE = "key_optimize"
        fun newInstance(code: String, optimize: Boolean) = TreeFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_CODE, code)
                putBoolean(KEY_OPTIMIZE, optimize)
            }
        }
    }

    override fun createPresenterInstance() {
        presenter = TreePresenter()
    }

    override fun initPresenter() {
        presenter?.attachView(this)
        val code = arguments!!.getString(KEY_CODE)!!
        val optimize = arguments!!.getBoolean(KEY_OPTIMIZE)
        presenter?.init(code, optimize, activity as Navigation)
        if(optimize) buttonOptimize.visibility = View.GONE
    }

    override fun initViews(view: View?) {
        buttonOptimize.setOnClickListener { presenter?.onOptimizeClick() }
        buttonExecute.setOnClickListener { presenter?.onExecuteClick() }
    }

    override fun updateTree(expression: Expression) {
        treeView.setData(expression)
    }

}