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
import java.io.*
import java.lang.Exception
import java.sql.Types.NULL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            // 5. DB 오픈
            var helper = DBHelper(this)
            var db = helper.writableDatabase

            // 6. sql 쿼리 작성
            var sql = "insert into TestTable (textData, intData, floatData, dataData) values (?, ?, ?, ?)"


            // 날짜(date)를 패턴으로 지정한 문자열로 뽑아낼 수 있는것
            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
           var date = sdf.format(Date())

            // 7. 쿼리에 들어갈 데이터 세팅
            var arg1 = arrayOf("문자열1", "100", "11.11", date)
            var arg2 = arrayOf("문자열2", "200", "22.22", date)

            db.execSQL(sql, arg1)
            db.execSQL(sql, arg2)

            db.close()

            textView.text = "저장 완료"
        }
    }
}
