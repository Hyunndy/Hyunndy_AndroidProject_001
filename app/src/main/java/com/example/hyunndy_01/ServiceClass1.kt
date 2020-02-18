package com.example.hyunndy_01

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class ServiceClass1 : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        // 5. 시작하면 불리는 메소드에 쓰레드 start()처리.
        var thread = ThreadClass()
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }


    // 6. 서비스가 종료되면 불리는 메서드.
    override fun onDestroy() {
        super.onDestroy()

        Log.d("test1", "서비스 실행 종료!")
    }

    // 4.
    // 시작하면 쓰레드에서 작업처리를 하기 위해 스레드 하나 생성.
    // 인텐트 서비스를 사용하면 이렇게 스레드 클래스를 따로 만들 필요없이 바로 인텐트 서비스의 onHandleIntent()를 사용한다.
    inner class ThreadClass : Thread(){

        override fun run() {
            var idx = 0
            while(idx <10)
            {
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()
                Log.d("test1", "Service Running : ${time}")

                idx++
            }
        }

    }
}
