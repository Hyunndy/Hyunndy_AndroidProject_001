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
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var permission_list = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    // 2. 외부저장소 파일 경로를 담을 변수 생성
    var path : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 3. 외부저장소 경로 + "/android/data/" + 패키지명이기 때문에 어플이 삭제되면 같이 삭제된다.
        path = Environment.getExternalStorageDirectory().absolutePath + "/android/data/" + packageName

        // 1. 권한 요청
        checkPermission()

        // 4.path 경로에 해당하는 디렉토리가 없으면 만든다.
        var file = File(path)
        if(file.exists() == false)
        {
            file.mkdir()
        }

        button3.setOnClickListener { view ->
            try {

                var output = FileOutputStream(path + "/sdFile.dat")
                var dos = DataOutputStream(output)
                dos.writeInt(200)
                dos.writeUTF("반갑습니다")
                dos.flush()
                dos.close()
                textView.text = "저장완료"

            }catch (e : Exception)
            {
                e.printStackTrace()
            }
        }

        button4.setOnClickListener { view ->

            try {

                // 4. dataInputStream 추출
                var input = FileInputStream(path + "/sdFile.dat")

                // 5. 데이터 읽어오기.
                var dis = DataInputStream(input)
                var value1 = dis.readInt()
                var value2 = dis.readUTF()
                dis.close()

                textView.text = "value1 : ${value1}\n"
                textView.append("value2 : ${value2}\n")

            }catch (e : Exception)
            {
                e.printStackTrace()
            }
        }
    }


    fun checkPermission()
    {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {
            return
        }

        for(permission in permission_list)
        {
            var chk = checkCallingOrSelfPermission(permission)
            if(chk == PackageManager.PERMISSION_DENIED)
            {
                requestPermissions(permission_list, 0)
            }
        }
    }
}
