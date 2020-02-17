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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }

        var sync = AsyncTaskClass()

        // 1. AsyncTask 가동. execute()의 매개변수는 그대로 doInBackground()의 매개변수로 넘어간다.
        sync.execute(10, 20)
    }


    // 제네릭 타입을 3개 지정해주어야 한다.
    // 제네릭1) excute() 매개변수 타입
    // 제네릭2) publishProgress() 매개변수 타입
    // 제네릭3) doInBackground()의 반환 타입 이자 onPostExcute의 매개변수 타입
    inner class AsyncTaskClass : AsyncTask<Int, Long, String>() {

        // doInBackground 메서드가 호출되기 전에 딱 한 번 호출되는 메서드.  Main Thread가 처리한다.
        override fun onPreExecute() {
            super.onPreExecute()

            textView2.text = " AsyncTask 가동 ";
        }

        //  일반 Thread에서 처리한다.  네트워크 작업 or 5초 이상 걸리는 작업을 이 메서드에서 처리한다.
        // 1. execute()의 매개변수는 그대로 doInBackground()의 매개변수로 넘어간다.
        override fun doInBackground(vararg params: Int?): String {

            // 2.
            // varag params에는 ?가 붙어서 NULL을 허용하지만, 정수 값을 뽑아낼거기 때문에 NULL을 허용하면 안되므로
            // NULL을 허용하는 변수를 NULL을 허용하지 않는 변수에 넣고싶을 때는 느낌표2개(!!)을 붙여주면 된다.
            var a1 = params[0]!!
            var a2 = params[1]!!

            for (idx in 0..9) {
                SystemClock.sleep(100)

                a1++
                a2++

                // 3.
                // 이렇게하면 되긴하는데 WrongThread 경고가 뜬다. 안드로이드는 일반 쓰레드에서 화면 처리를 하면 경고를 보낸다. 따라서 좋은 코드가 아님.
                //textView2.text = " ${idx} : ${a1}, ${a2}"


                // 4.
                // doInBackground() 에서 화면처리를 하려면 onProgressUpdate() 함수가 필요하고, 그 함수는 publishProgress()로 호출할 수 있다.
                // publishProgress(varags 변수) 매개변수가 onProgressUpdate(varags 변수)로 전달된다. 값 여러개 전달하면 배열로 만들어져 전달된다.
                // 메인쓰레드가 한가할 때 publishProgress()를 호출해준다.
                var time = System.currentTimeMillis()
                publishProgress(time)

            }

            return "지존현지"
        }

        // 4.
        // doInBackground 메서드에서 publishProgress 메서드를 호출하면 Main Thread가 처리하는 메서드. doInBackground 메서드 내에서 화면 처리가 필요할 때 사용한다.
        override fun onProgressUpdate(vararg values: Long?) {
            super.onProgressUpdate(*values)

            textView2.text = "Async : ${values[0]}"
        }

        // 5.
        // doInBackground()의 반환 타입이 매개변수로 넘어온다.
        // doInBackground 메서드 수행 완료 후 호출. MainThread가 처리한다.
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            textView2.text = result
        }
    }
}
