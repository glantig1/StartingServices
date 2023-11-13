package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        someTimer(100)
        return super.onStartCommand(intent, flags, startId)
    }
    fun someTimer(time: Int){
        val scope = CoroutineScope(Job() + Dispatchers.Default)

        scope.launch {
            repeat(time){
                Log.d("Count Down", (100 - it).toString())
                delay(1000)
            }
        }


    }
}
