package com.example.runningapp2.models

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.example.runningapp2.MainActivity
import com.example.runningapp2.R
import com.example.runningapp2.other.Constants
import com.example.runningapp2.other.Constants.ACTION_PAUSE_SERVICE
import com.example.runningapp2.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runningapp2.other.Constants.ACTION_STOP_SERVICE
import com.example.runningapp2.other.Constants.NOTIFICATION_CHANNEL_ID
import com.example.runningapp2.other.Constants.NOTIFICATION_ID
import androidx.annotation.RequiresApi
import com.example.runningapp2.other.Constants.NOTIFICATION_CHANNEL_NAME

class TrackingService: LifecycleService() {

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun) {
                        startForegroundService()
                        isFirstRun = false
                    }
                    else
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

    private fun startForegroundService(){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
        as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())
            .build()

        startForeground(NOTIFICATION_ID, notificationBuilder)
    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = Constants.ACTION_SHOW_TRACKING_FRAGMENT
        },
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager){
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}