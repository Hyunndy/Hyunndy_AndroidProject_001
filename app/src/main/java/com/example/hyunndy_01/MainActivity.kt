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
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
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

    var handler : Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 버튼을 누를 때 마다 현재 시간 textview에 출력
        button.setOnClickListener {  view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }

        /*
        // 2. 100ms마다 현재시간이 출력되게. (무한루프라 메인스레드 다운됨)
        while(true)
        {
            SystemClock.sleep(100)
            var time = System.currentTimeMillis()
            textView2.text = "while : ${time}"
        }
        */

        // 4. Handler가 요청하게. handler.post(thread) 함수가 호출되면 안드로이드 OS가 한가해질때 마다 작업을 요청한다.
        handler = Handler();

        var thread = ThreadClass()
        //handler?.post(thread)
        // 6. 만일 post에 딜레이를 주고싶다면
        handler?.postDelayed(thread, 100)

    }

    // 3. Handler 사용을 위해 Thread 생성
    inner class ThreadClass : Thread()
    {
        override fun run() {
            var time = System.currentTimeMillis()
            textView2.text = "Handler : ${time}"

            // 5. 만약 시간 출력을 무한루프로 돌리고싶다면 WHILE문을 쓰면 ANR 현상이 일어난다. 따라서 마지막에 Handler가 post함수를 또 호출하게 한다.
            // handler?.post(thread)
            handler?.postDelayed(this, 100 )
        }
    }
}
