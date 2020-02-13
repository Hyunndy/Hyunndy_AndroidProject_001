package com.example.hyunndy_01

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.content.Intent
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

        button2.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("pending", "pendingIntent")
            builder.setContentTitle("notification 1")
            builder.setContentText("알림메세지 1 입니다")
            builder.setSmallIcon(R.drawable.images)
            builder.setAutoCancel(true)

            //2. Intent 생성
            // Intent란 안드로이드 OS에게 저 이거 실행시켜주세요 시키는 것
            var intent1 = Intent(this, TestActivity1::class.java)


            // Notification 눌렀을 때 나오는 Activity에서 데이터를 뽑아쓰기 위해 putExtra.
            intent1.putExtra("data1", "문자열 데이터1")
            intent1.putExtra("data2", 100)

            var intent2 = Intent(this, TestActivity2::class.java)
            intent2.putExtra("data2", "testactivity2 실행")
            var pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            var builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action 1", pending2)
            var action2 = builder2.build()
            builder.addAction(action2)


            // 플래그를 꼭 FLAG_UPDATE_CURRENT로 해줘야 데이터가 잘 전달된다.
            var pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)

        }

        button3.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("pending", "pendingIntent")
            builder.setContentTitle("notification 2")
            builder.setContentText("알림메세지 2 입니다")
            builder.setSmallIcon(R.drawable.images)
            builder.setAutoCancel(true)

            //2. Intent 생성
            // Intent란 안드로이드 OS에게 저 이거 실행시켜주세요 시키는 것
            var intent1 = Intent(this, TestActivity2::class.java)

            var pending1 = PendingIntent.getActivity(this, 0, intent1, 0)
            builder.setContentIntent(pending1)


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)

        }


        button4.setOnClickListener { view ->

            // 1. 노티피케이션 빌더 생성
            var builder = getNotificationBuilder1("pending", "pendingIntent")
            builder.setContentTitle("notification 3")
            builder.setContentText("알림메세지 3 입니다")
            builder.setSmallIcon(R.drawable.images)
            builder.setAutoCancel(true)

            //2. Intent 생성
            // Intent란 안드로이드 OS에게 저 이거 실행시켜주세요 시키는 것
            var intent1 = Intent(this, TestActivity1::class.java)


            // Notification 눌렀을 때 나오는 Activity에서 데이터를 뽑아쓰기 위해 putExtra.
            intent1.putExtra("data1", "문자열 데이터3")
            intent1.putExtra("data2", 300)

            // 플래그를 꼭 FLAG_UPDATE_CURRENT로 해줘야 데이터가 잘 전달된다.
            // requestCode
            var pending1 = PendingIntent.getActivity(this, 20, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(pending1)


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)

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
