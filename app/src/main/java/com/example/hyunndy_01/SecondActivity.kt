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


        // 10. 메인 액티비티에서 Intent로 보낸 객체들의 값들을 받는다!
        var t1 = intent.getParcelableExtra<TestClass>("test")

        textView2.text = "t1.data1 : ${t1.data10}\n"
        textView2.append("t2.data2 : ${t1.data20}")

        button10.setOnClickListener { view ->

            // 11. main으로도 보내기.
            var t2 = TestClass()
            t2.data10 = 200
            t2.data20 = "문자열2"

            var intent2 = Intent()
            intent2.putExtra("test2", t2)

            setResult(Activity.RESULT_OK, intent2)
            finish()
        }
    }


}
