package com.ittyo.coroutineexperiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // delay is suspended function which must be called inside coroutineScope
        // in this code we use GlobalScope.launch { } to create coroutine scope
        // which will return a Job
        // we can cancel the job (coroutine execution) using job.cancel()
        job = GlobalScope.launch {
            delay(5000)
            Log.d("Coroutine","World")
        }
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
    }
}