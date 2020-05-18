package com.mars.interpreterandroid.presentation.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.solver.widgets.Optimizer
import com.mars.interpreterandroid.R
import com.mars.interpreterandroid.presentation.fragments.result.impl.ResultFragment
import com.mars.interpreterandroid.presentation.fragments.start.StartContract
import com.mars.interpreterandroid.presentation.fragments.start.impl.StartFragment
import com.mars.interpreterandroid.presentation.fragments.tree.impl.TreeFragment

class MainActivity : AppCompatActivity(),
    Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ContextStorage.context = Context { Log.d("RESULT OUTPUT", it) }
//        val code = FileAdapter.readInputFile(this)
//        val someVar = AppBuilder.build(code.joinToString("\n")).optimize()
//        treeView.setData(someVar)
//        someVar.solve(ContextStorage.context)
        openStartScreen()
    }

   override fun openStartScreen() {
       supportFragmentManager.beginTransaction().apply {
           add(R.id.contentFrame, StartFragment.newInstance())
           commit()
       }
   }

    override fun openTreeScreen(code: String) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.contentFrame, TreeFragment.newInstance(code, false))
            commit()
        }
    }

    override fun openOptimisedScreen(code: String) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.contentFrame, TreeFragment.newInstance(code, true))
            commit()
        }
    }

    override fun openResultScreen(code: String, optimize: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.contentFrame, ResultFragment.newInstance(code, optimize))
            commit()
        }
    }
}
