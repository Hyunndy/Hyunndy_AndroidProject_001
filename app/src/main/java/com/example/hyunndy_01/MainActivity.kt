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


        button2.setOnClickListener { view ->

            // 8. Parcelable 인터페이스를 구현한 클래스 객체를 만든다.
            var t1 = TestClass()
            t1.data10 = 100
            t1.data20 = "문자열2"

            var intent = Intent(this, SecondActivity::class.java)

            // 9. intent에 TestClass 객체를 넣는다. (정확히는 TestClass가 가진 값들)
            intent.putExtra("test", t1);
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }


    // 12. second 액티비티에서 보낸 데이터 받기.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK)
        {
            var t2 = data?.getParcelableExtra<TestClass>("test2")
            textView.text = "t2.data1 : ${t2?.data10}\n"
            textView.append("t2.data2 : ${t2?.data20}")
        }
    }
}
