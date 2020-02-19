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
import java.io.DataInputStream
import java.io.DataOutputStream
import java.lang.Exception
import java.sql.Types.NULL
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            // 1. 예외처리
            try{

                // 2. FileOutputStream 추출 -> 내부저장소와 연결되어있는 스트림.
                // APPEND : 추가 / PRIVATE : 덮어씀
                // 내부 저장소에 "myFile"이라는 데이터를 만든거고, 이 파일에다가 데이터를 쓴것.
                var output = openFileOutput("myFile.dat", Context.MODE_PRIVATE)

                // 3. 새로 생성한 데이터 쓰기.
                var dos = DataOutputStream(output)
                dos.writeInt(100)
                dos.writeDouble(11.11)
                dos.writeUTF("안녕하세요")
                dos.flush()
                dos.close()

                textView.text = "저장완료"

            }catch (e : Exception)
            {
                e.printStackTrace()
            }
        }

        button2.setOnClickListener { view ->

            try {

                // 4. dataInputStream 추출
                var input = openFileInput("myFile.dat")

                // 5. 데이터 읽어오기.
                var dis = DataInputStream(input)
                var value1 = dis.readInt()
                var value2 = dis.readDouble()
                var value3 = dis.readUTF()
                dis.close()

                textView.text = "value1 : ${value1}\n"
                textView.append("value2 : ${value2}\n")
                textView.append("value3 : ${value3}\n")

            }catch (e : Exception)
            {
                e.printStackTrace()
            }
        }

    }
}
