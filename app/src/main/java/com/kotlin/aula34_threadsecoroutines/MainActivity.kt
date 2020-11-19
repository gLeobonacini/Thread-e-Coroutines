package com.kotlin.aula34_threadsecoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val repo = Repository()

    val viewModel by viewModels<MainViewModel>{
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repo) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getFilmeRepository()

        viewModel.res.observe(this, Observer {
            tvResultado.text = it
        })

        //btnThread.setOnClickListener {
        //    Thread(Runnable {
        //        Thread.sleep(5000)
        //        runOnUiThread {
        //            tvResultado.text = "Click Thread"
        //        }
        //    }).start()
        //}

        //btnHandler.setOnClickListener {
        //    Handler(Looper.getMainLooper()).postDelayed({
        //        tvResultado.text = "Click Handler"
        //    },5000)
        //}

        //btnCoroutines.setOnClickListener {
        //    scope.launch {
        //        delay(5000)
        //        tvResultado.text = "Click Coroutines"
        //    }
        //}
    }
}