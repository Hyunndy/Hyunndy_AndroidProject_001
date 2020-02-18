package com.example.hyunndy_01

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.hyunndy_01.action.FOO"
private const val ACTION_BAZ = "com.example.hyunndy_01.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.example.hyunndy_01.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.hyunndy_01.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class ServiceClass2 : IntentService("ServiceClass2") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    // 5.
    // onStartCommand()가 호출되고 자동으로 호출되는 메서드.
    // 일반 Thread 처럼 동작하므로 우리가 Thread로 따로 처리하고싶은 코드를 다 여기다가 넣어주면 된다.
    override fun onHandleIntent(intent: Intent?) {

        var idx = 0
        while(idx <10)
        {
            SystemClock.sleep(100)
            var time = System.currentTimeMillis()
            Log.d("test2", "Service Running : ${time}")

            idx++
        }
    }
}
