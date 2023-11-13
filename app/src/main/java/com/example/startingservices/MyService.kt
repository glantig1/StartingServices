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
    var enter = 0
    var startId = 0
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        this.startId = startId
        someTimer()
        return super.onStartCommand(intent, flags, startId)
    }
    fun someTimer(){
        val scope = CoroutineScope(Job() + Dispatchers.Default)
        scope.launch {
            repeat(enter){
                Log.d("Count Down", (enter - it).toString())
                delay(1000)
            }
            stopSelf(startId)
        }.start()
    }
}
