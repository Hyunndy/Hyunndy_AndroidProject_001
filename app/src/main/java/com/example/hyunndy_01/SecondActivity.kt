package com.example.hyunndy_01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 4. 데이터 받아오기. 만일 올 데이터가 없으면 두 번째 매개변수인 defaultvalue가 들어간다.
        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        var data3 = intent.getBooleanExtra("data3", false)
        var data4 = intent.getStringExtra("data4")

        textView2.text = "data1 = ${data1}\n"
        textView2.append("data2 = ${data2}\n")
        textView2.append("data3 = ${data3}\n")
        textView2.append("data4 = ${data4}\n")


        button10.setOnClickListener { view ->

            // 5. Main Activity로 전달할 때  데이터를 전달
            var intent2 = Intent()
            intent2.putExtra("value1", 200)
            intent2.putExtra("value2", 22.22)
            intent2.putExtra("value3", true)
            intent2.putExtra("value4", "문자열2")

            setResult(RESULT_OK, intent2)

            finish()
        }
    }
}
