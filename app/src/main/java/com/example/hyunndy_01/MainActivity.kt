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
    var input_fragment = FirstFragment()
    var result_fragment = SecondFragment()

    // 4. 프래그먼트1의 EditText를 프래그먼트2에 전달할 변수 선언
    var value1:String? = null
    var value2:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("input")
    }

    // 2. Activity에 배치할 Fragment 세팅
    fun setFragment(name : String)
    {
        var tran = supportFragmentManager.beginTransaction()
        when(name)
        {
            "input"->
            {
                tran.replace(R.id.container, input_fragment)
            }
            "result"->
            {
                tran.replace(R.id.container, result_fragment)
                tran.addToBackStack(null)
            }
        }

        tran.commit()
    }
}
