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
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener { view ->

            // 1. 안드로이드OS는 자신이 가지고있는 App의 모든 구성요소를 저장하고있기 때문에 가져올 수 있다.
            // 다른 어플에서 카카오톡으로 로그인하기 이런 기능들이 모두 이것을 이용해서 하는것이다.
            var intent = Intent("android.intent.action.SECOND")

            // 2. 다른 App의 Activity를 실행시킬 때 Data전달하기.
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)

            startActivityForResult(intent, SECOND_ACTIVITY)


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK)
        {
            var data1 = data?.getIntExtra("value1", 0)
            var data2 = data?.getDoubleExtra("value2", 0.0)

            textView.text = "data1 = ${data1}\n"
            textView.append("data2 = ${data2}")
        }
    }
}
