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
        fun newInstance(code: String) = TreeFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_CODE, code)
            }
        }
    }

    override fun createPresenterInstance() {
        presenter = TreePresenter()
    }

    override fun initPresenter() {
        presenter?.attachView(this)
        val code = arguments!!.getString(KEY_CODE)!!
        presenter?.init(code, activity as Navigation)
    }

    override fun initViews(view: View?) {
        buttonOptimize.setOnClickListener { presenter?.onOptimizeClick() }
        buttonExecute.setOnClickListener { presenter?.onExecuteClick() }
    }

    override fun updateTree(expression: Expression) {
        treeView.setData(expression)
    }

}