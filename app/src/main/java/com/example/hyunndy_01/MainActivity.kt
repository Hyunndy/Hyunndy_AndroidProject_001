package com.example.hyunndy_01

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.content.Intent
import android.graphics.Bitmap
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            // 1. 빌더 세팅
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("빅픽쳐 노티피케이션")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            // 2. 빅픽쳐 스타일 세팅
            var big = NotificationCompat.BigPictureStyle(builder)
            var bitmap = BitmapFactory.decodeResource(resources, R.drawable.images)
            big.bigPicture(bitmap)
            big.setBigContentTitle("빅컨텐트타이틀")
            big.setSummaryText("서머리")

            // 3. 노티피케이션 객체 만들어서 띄우기
            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button2.setOnClickListener { view ->
            // 1. 빌더 세팅
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("빅픽쳐 노티피케이션")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            // 2. 빅텍스트 스타일 세팅
            var big = NotificationCompat.BigTextStyle(builder)
            big.setSummaryText("서머리 텍스트")
            big.setBigContentTitle("빅 컨텐트 타이틀")
            big.bigText("동해물과 백두산이 마르고 닳도록 동해물과 백두산이 마르고 닳도록 동해물과 백두산이 마르고 닳도록동해물과 백두산이 마르고 닳도록 동해물과 백두산이 마르고 닳도록 ")

            // 3. 노티피케이션 객체 만들어서 띄우기
            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        button3.setOnClickListener { view ->
            // 1. 빌더 세팅
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("빅픽쳐 노티피케이션")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            // 2. 인박스  스타일 세팅
            var inbox = NotificationCompat.InboxStyle(builder)
            inbox.setSummaryText("인박스 서머리")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")


            // 3. 노티피케이션 객체 만들어서 띄우기
            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder{
        var builder:NotificationCompat.Builder? = null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            // 매니저 생성
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 채널 생성
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
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
