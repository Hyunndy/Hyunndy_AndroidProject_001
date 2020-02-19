package com.example.hyunndy_01

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class ServiceClass1 : Service() {

    // 1. IPC 개념을 사용해서 이 value값을 액티비티에서 가져와서 사용해보도록 한다.
    var value = 0
    var thread:ThreadClass? = null

    // 6. 바인더 객체 생성
    var binder : IBinder = LocalBinder()
    // 외부에서 서비스에 접속하게 되면 자동으로 onBind()가 호출된다.
    // 이 함수가 리턴하는 IBinder 객체를 액티비티에서 얻어와서 서비스가 사용하는 값을 사용할 수 있다.
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        // 1. 서비스에서 가동시킬 쓰레드 가동
        thread = ThreadClass()
        thread?.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("test1", "서비스 실행 종료!")
    }

    inner class ThreadClass : Thread(){

        override fun run() {
            while(true)
            {
                SystemClock.sleep(1000)
                //var time = System.currentTimeMillis()
                Log.d("test1", "Service Running : ${value}")
                value++
            }
        }
    }

    // 4.
    // IPC 개념을 사용하기 위해 액티비티에서 value값을 얻어올텐데 getNumber()을 사용해서 값을 얻어오려면 이 클래스의 객체를 생성하고 그 객체를 통해서 얻어오는 수 밖에 없다.
    // 하지만 이 클래스의 객체는 안드로이드OS가 만드는거라 개발자의 입장에서 주소값을 직접적으로 가져올 수는 없다.
    // 그래서 안드로이드에서는 Binder라는 클래스를 이용해서 액티비티-서비스의 중간단계 역할을 하게 한다.
    // 따라서 액티비티에서 바인더객체를 통해 서비스에서 사용하는 값을 가져올 수 있다.
    fun getNumber() : Int{
        return value
    }

    // 5. 바인더 생성
    inner class LocalBinder : Binder()
    {
        // 바인더를 통해 서비스 객체의 주소값을 액티비티에게 반환.
        fun getService() : ServiceClass1{
            return this@ServiceClass1
        }
    }
}
