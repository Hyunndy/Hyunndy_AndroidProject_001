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

    // 6. 상수 정의
    private val SECOND_ACTIVITY = 1
    private val THIRD_ACTIVITY = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 버튼을 눌러서 두번째 액티비티를 실행시킨다.
        button2.setOnClickListener { view ->

            // 2. 인텐트 객체 생성
            var intent = Intent(this, SecondActivity::class.java)

            // 3. 이 Intent를 실행시켜줘! 안드로이드os야!
            startActivityForResult(intent, SECOND_ACTIVITY)
        }

        button3.setOnClickListener {  view ->

            // 5. 서드액티비티로 이동하는 인텐트
            var intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, THIRD_ACTIVITY)
        }
    }


    // 4.
    // startActivityForResult()로 SecondActivity를 실행시켰기 때문에 거기서 finish()하고 돌아왔을 때 자동으로 이 함수가 호출.

    // requestCode : Main Activity에서 갔다가 돌아온 Activity가 여러개 일 수 있기 때문에 그걸 구분해주기 위해 사용하는 코드. 어떤 액티비티에서 finish하고 돌아왔는지 구분해주기 위한 코드.
    // resultCode : 다른 activity로 들어가서 작업을 했고, 그 작업의 결과가 어떤지 알려주는 코드. 작업하는 액티비티에서 setResult()로 설정 가능.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode)
        {
            SECOND_ACTIVITY ->
            {
                textView.text = "세컨액티비티에서 돌아옴"

                // 7. 전달받은 resultCode로 분기 가능.
                when(resultCode)
                {
                   Activity.RESULT_OK -> {
                       textView.text = "asdsad"
                    }
                    Activity.RESULT_CANCELED -> {
                        textView.text = "asdasd"
                    }
                    Activity.RESULT_FIRST_USER -> {
                        textView.text = "asda"
                    }
                }
            }

            THIRD_ACTIVITY -> {
                textView.text = "서드액티비티에서 돌아옴"
            }
        }

    }
}
