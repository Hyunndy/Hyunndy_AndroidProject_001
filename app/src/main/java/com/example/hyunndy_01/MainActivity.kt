package com.example.hyunndy_01

import android.Manifest
import android.app.*
import android.content.*
import android.content.DialogInterface.*
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

    // 1. 사용할 프래그먼트들의 객체를 생성
    var first = FirstFragment()
    var second = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. 첫번째 프래그먼트 세팅.
        button.setOnClickListener { view ->
            // 2. 하위버전까지 지원하려면 supportFragmnetManager.
            var tran = supportFragmentManager.beginTransaction()

            // 3. id가 container인 레이아웃에 first라는 프래그먼트를 넣는다.
            tran.add(R.id.container, first)

            // 4. BackButton으로 프래그먼트를 제거할 수 있도록 적용.
            tran.addToBackStack(null)
            tran.commit()
        }

        // 3. 두번째 프래그먼트 세팅.
        button2.setOnClickListener { view ->

            var tran = supportFragmentManager.beginTransaction()

            tran.replace(R.id.container, second)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}
