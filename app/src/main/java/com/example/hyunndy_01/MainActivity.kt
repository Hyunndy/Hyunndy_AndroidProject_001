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

    var brapp1:TestReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addReceiver()

        // 3. Intent를 이용해 BR가동.
        button.setOnClickListener { view ->

            var intent = Intent(this, TestReceiver::class.java)
            sendBroadcast(intent)
        }
    }

    // 안드로이드 8.0 이상에서의 암시적 인텐트는 해당 리시버를 갖고있는 어플이 작동중일 때만 가능하기 때문에
    // 코드상으로 끄고, 키고를 관리해줘야한다.
    fun addReceiver()
    {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
        {
            return
        }

        brapp1 = TestReceiver()
        var filter = IntentFilter("com.test.brapp1")
        registerReceiver(brapp1, filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        if(brapp1 != null)
        {
            unregisterReceiver(brapp1)
            brapp1 = null
        }
    }
}
