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

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            var now = System.currentTimeMillis()
            textView.text = "버튼클릭 : ${now}"
        }

        // 1. Activity에 있는 코드가 굉장히 바쁘면 화면 처리가 안될 수 있다.
        // ANR 유발 코드.
        /*
        while(true)
        {
            var now = System.currentTimeMillis()
            textView2.text = "무한 루프 : ${now}"
        }
        */

        // 3. 액티비티가 종료되면 안드로이드os가 굴리는 메인쓰레드만 종료되며,
        // 내가 만든 쓰레드는 계속 이어진다.

        isRunning = true
        var thread = ThreadClass1()
        thread.start()
    }

    // 2. 쓰레드 클래스 생성
    inner class ThreadClass1 : Thread()
    {
        override fun run() {
            while(isRunning)
            {
                // 100ms만큼 이 부분에서 쉰다는 뜻
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${now}")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        isRunning = false
    }
}
