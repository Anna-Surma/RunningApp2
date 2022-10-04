package com.example.runningapp2.models

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.example.runningapp2.other.Constants.ACTION_PAUSE_SERVICE
import com.example.runningapp2.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runningapp2.other.Constants.ACTION_STOP_SERVICE

class TrackingService: LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Log.i("Tracking Service", "Started or resumed service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Log.i("Tracking Service","Paused service")
                }
                ACTION_STOP_SERVICE -> {
                    Log.i("Tracking Service","Stopped service")
                }
                else -> { Log.i("Tracking Service","Unknown") }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}