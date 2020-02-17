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
import kotlinx.android.synthetic.main.activity_second.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY = 1
    private val THIRD_ACTIVITY = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 버튼을 눌러서 두번째 액티비티를 실행시킨다.
        button2.setOnClickListener { view ->

            // 2. 인텐트 객체 생성
            var intent = Intent(this, SecondActivity::class.java)


            // 3. Intent에 데이터 세팅.
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            intent.putExtra("data3", true)
            intent.putExtra("data4", "문자열")

            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 7. 세컨드 액티비티에서 넘어온 intent에서 데이터를 뽑는다.
        if(resultCode == Activity.RESULT_OK)
        {
            var value1 = data?.getIntExtra("value1", 0)
            var value2 = data?.getDoubleExtra("value2", 0.0)
            var value3 = data?.getBooleanExtra("value3", false)
            var value4 = data?.getStringExtra("value4")

            textView.text = "data1 = ${value1}\n"
            textView.append("data2 = ${value2}\n")
            textView.append("data3 = ${value3}\n")
            textView.append("data4 = ${value4}\n")
        }
    }
}
