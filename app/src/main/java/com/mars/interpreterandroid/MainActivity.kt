package com.mars.interpreterandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mars.FileAdapter
import com.mars.interpreterandroid.data.context.Context
import com.mars.interpreterandroid.data.context.ContextStorage
import com.mars.interpreterandroid.data.execution.builder.AppBuilder
import com.mars.interpreterandroid.data.execution.optimization.optimize
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ContextStorage.context = Context { Log.d("RESULT OUTPUT", it) }

        val code = FileAdapter.readInputFile(this)


        val someVar = AppBuilder.build(code.joinToString("\n")).optimize()

        treeView.setData(someVar)


        someVar.solve(ContextStorage.context)
    }


}
