package com.example.hyunndy_01

import android.Manifest
import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.CalendarContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    // 3. Activity가 종료되면 Thread도 종료될 수 있게 bool 변수 선언.
    var IsRunning:Boolean = false

    // 4. 개발자가 만든 쓰레드에서 화면처리 작업을 위해 Handler 생성
    var handler : DisplayHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 버튼을 누를 때 마다 현재 시간 textview에 출력
        button.setOnClickListener {  view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }


        handler = DisplayHandler()

        // 2. Thread start
        IsRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    // 2. Handler 사용을 위해 Thread 생성
    inner class ThreadClass : Thread()
    {
        override fun run() {

            while(IsRunning) {
                SystemClock.sleep(100)
                var time = System.currentTimeMillis()

                Log.d("test1", "쓰레드 : ${time}")
                //textView2.text = "Handler : ${time}"

                // 5. 개발자가 만든 Thread에서 Handler를 호출하게되면 MainThread가 한가할 때 작업 요청이 가능하다.

                // 5-1) 이 예제의 경우 Handler안에서 Time을 처리할 때는 걍 EmptyMessage만 보내도 된다.
                handler?.sendEmptyMessage(0)

                // 5-2) Message 객체에 여러개를 실어 보낼 수 있다.

                // Message.what = handler로 넘기는 작업의 Index개념.
                // Message.obj = 객체가 넘어가는것이기 때문에 Any 객체나 될 수 있다.
                var msg = Message()
                msg.what = 0
                msg.obj = time
                handler?.sendMessage(msg)
            }
        }
    }

    // 3. Activity가 종료되면 Thread도 종료될 수 있게 bool 변수 선언.
    override fun onDestroy() {
        super.onDestroy()

        IsRunning = false
    }

    // 4. 개발자가 만든 쓰레드에서 화면처리 작업을 위해 Handler 생성
    inner class DisplayHandler : Handler()
    {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {

                // 5-1.
                //var time = System.currentTimeMillis()
                //textView2.text = " Handler : ${time}"

                // 5-2.
                textView2.text = "Handler : ${msg?.obj}"
            }
        }
    }
}
