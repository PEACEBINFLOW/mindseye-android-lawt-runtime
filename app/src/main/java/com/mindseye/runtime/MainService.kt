package com.mindseye.runtime

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MainService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        DuoBluetoothManager.init(this)
        LAWTRuntime.init()
        
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
