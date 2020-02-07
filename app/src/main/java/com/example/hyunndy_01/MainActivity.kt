package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var text2:TextView? = null;
        //text2 = findViewById<TextView>(R.id.textView3);
        //text2?.setText("존예현지");

        //아이디에 해당하는 변수가 자동으로 생성되고 그 객체의 주소값이 자동으로 들어간다.
        textView3.text = "지젼현지";
    }
}
