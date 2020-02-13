package com.example.hyunndy_01

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    var data1 = arrayOf("지존", "현지", "존예")
    var data2 = arrayOf("슬림쿡", "다이어트", "도시락")
    var data3 = intArrayOf(R.drawable.images, R.drawable.images, R.drawable.images)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("channel1", "첫 번째 채널")

            // 2. 티커 생성
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            //3. 비트맵객체 = 안드로이드에서 이미지를 객체로 만든 것.
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)

            builder.setNumber(100)

            //사용자가 메세지를 클릭하면 자동 제거
            builder.setAutoCancel(true)

            builder.setContentTitle("Content Title")
            builder.setContentText("Content Text")

            // 4. 노티피케이션 생성
            var notification = builder.build()

            // 5. 노티피케이션 메시지를 관리하는 노티피케이션 매니저 생성.
            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // 알림창에서 각 알림을 구분하는 id.
            mng.notify(10, notification)

            // 6. 노티피케이션 채널

        }

        button3.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("channel3", "3 번째 채널")

            // 2. 티커 생성
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            //3. 비트맵객체 = 안드로이드에서 이미지를 객체로 만든 것.
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)

            builder.setNumber(100)

            //사용자가 메세지를 클릭하면 자동 제거
            builder.setAutoCancel(true)

            builder.setContentTitle("Content Title")
            builder.setContentText("Content Text")

            // 4. 노티피케이션 생성
            var notification = builder.build()

            // 5. 노티피케이션 메시지를 관리하는 노티피케이션 매니저 생성.
            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // 알림창에서 각 알림을 구분하는 id.
            mng.notify(30, notification)

            // 6. 노티피케이션 채널

        }

        button4.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("channel2", "2번째 채널")

            // 2. 티커 생성
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)

            //3. 비트맵객체 = 안드로이드에서 이미지를 객체로 만든 것.
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)

            builder.setNumber(100)

            //사용자가 메세지를 클릭하면 자동 제거
            builder.setAutoCancel(true)

            builder.setContentTitle("Content Title")
            builder.setContentText("Content Text")

            // 4. 노티피케이션 생성
            var notification = builder.build()

            // 5. 노티피케이션 메시지를 관리하는 노티피케이션 매니저 생성.
            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // 알림창에서 각 알림을 구분하는 id.
            mng.notify(20, notification)

            // 6. 노티피케이션 채널

        }
    }



    fun getNotificationBuilder1(id:String, name:String) : NotificationCompat.Builder{
        var builder:NotificationCompat.Builder? = null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            // 매니저 생성
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 채널 생성
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            manager.createNotificationChannel(channel)

            //채널의 아이디를 넣어서 채널 아이디가 세팅된게 넘어가면서 채널별로 그룹화해서 노피티케이션을 만들 수 있다.
            builder = NotificationCompat.Builder(this, id)

        }
        else
        {
            // 8.0 이하에서는 노티피케이션 채널을 만들어줄 필요가 없다.
            builder = NotificationCompat.Builder(this)
        }


        return builder
    }
}
