package com.example.hyunndy_01

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat

class ServiceClass3 : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        // 6. 안드로이드 8.0 이상부터는 포그라운드 서비스 실행 후 5초 안에 노티피케이션을 띄워주지않으면 서비스가 강제 종료된다.
        var builder : NotificationCompat.Builder? = null


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel("test1", "service", NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, "test1")
        }
        else {
            builder = NotificationCompat.Builder(this)
        }

        builder?.setSmallIcon(android.R.drawable.ic_menu_search)
        builder?.setContentTitle("서비스 가동")
        builder?.setContentText("서비스가 가동중입니다")

        var notification = builder?.build()

        startForeground(10, notification)


        // 5. 시작하면 불리는 메소드에 쓰레드 start()처리.
        var thread = ThreadClass()
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    inner class ThreadClass : Thread(){

        override fun run() {
            var idx = 0
            while(idx <10)
            {
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()
                Log.d("test3", "Service Running : ${time}")

                idx++
            }
        }

    }
}
