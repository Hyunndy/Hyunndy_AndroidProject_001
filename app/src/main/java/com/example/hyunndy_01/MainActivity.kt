package com.example.hyunndy_01

import android.Manifest
import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.CalendarContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.sql.Types.NULL
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var survice_intent:Intent? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 서비스 가동
        button.setOnClickListener {  view ->
            survice_intent = Intent(this, ServiceClass1::class.java)
            startService(survice_intent)
        }

        // 2. 서비스 종료
        button2.setOnClickListener { view ->
            stopService(survice_intent)
        }

        // 3. 인텐트 서비스 가동
        button3.setOnClickListener { view ->
            survice_intent = Intent(this, ServiceClass2::class.java)
            startService(survice_intent)
            finish()
        }

        // 4. 포그라운드 서비스 가동
        button4.setOnClickListener { view ->
            survice_intent = Intent(this, ServiceClass3::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                startForegroundService(survice_intent)
            }
            else {
                startService(survice_intent)
            }
        }
    }
}
