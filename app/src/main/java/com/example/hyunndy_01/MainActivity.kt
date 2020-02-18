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
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {


    var permission_list = arrayOf(
            Manifest.permission.CALL_PHONE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. 지도 띄우기
        button.setOnClickListener { view ->

            // 1.지도를 띄우기 위해 위도 세팅
            var uri = Uri.parse("geo:37.243243,13861601")

            // 2. 액션뷰
            //  뭔가를 보여주는 목적으로 쓰임.
            //  뒤에 들어가는것이 무엇인가(Ex. 위도=지도, url=홈페이지 등)에 따라 뜨는게 다름.
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


        // 2. 홈페이지 띄우기
        button2.setOnClickListener { view ->

            var uri = Uri.parse("http://www.naver.com")

            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


        // 3. 번호 다이얼 띄우기
        button3.setOnClickListener { view ->

            var uri = Uri.parse("tel:01020562708")

            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        // 4. 자동으로 전화걸기
        // 전화거는건 돈이 나가므로 권한요청이 필요하다.
        checkPermission()

        button4.setOnClickListener { view ->

            var uri = Uri.parse("tel:01020562708")

            var intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }

    // 4. 전화걸기를 위한 권한 요청
    fun checkPermission()
    {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {
            return
        }
        for (permission : String in permission_list)
        {
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_DENIED)
            {
                requestPermissions(permission_list, 0)
            }
        }
    }
}
