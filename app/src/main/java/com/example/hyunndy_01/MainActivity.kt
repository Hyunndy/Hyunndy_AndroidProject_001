package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 리스너 객체 생성
        var listner = BtnListner();
        button16.setOnClickListener(listner);

        var listner2 = BtnListner2();
        button2.setOnClickListener(listner2);

        var listner3 = BtnListner3();
        button3.setOnClickListener(listner3);
        button4.setOnClickListener(listner3);



        //람다식으로 한다면?
        button5.setOnClickListener { view ->
            textView1.text = "이춘덕";
        }

        button6.setOnClickListener { view->
            textView1.text = "8월8일";
        }

        var listener4 = View.OnClickListener { view ->
            when(view.id) {
                R.id.button7 ->
                    textView1.text = "여자";
                R.id.button8 ->
                    textView1.text = "아톰";
            }
        }

        button6.setOnClickListener(listener4);
        button7.setOnClickListener(listener4);
    }

    // 자바 인터페이스는 implements
    // 코틀린에서는 상속이나 인터페이스 구현할 때 그냥 :콜론을 붙인다.
    inner class BtnListner: View.OnClickListener//인터페이스
    {
        override fun onClick(v: View?) {
            textView1.text = "지존 현지 지존 짱";
        }
    }

    inner class BtnListner2:View.OnClickListener
    {
        override fun onClick(v: View?) {
            textView1.text = "존예 현지 존나 예뻐";
        }
    }

    inner class BtnListner3:View.OnClickListener
    {
        override fun onClick(v: View?) {
            when(v?.id)
            {
                R.id.button3 ->
                    textView1.text = "존못";
                R.id.button4 ->
                    textView1.text = "2월7일";
            }

        }
    }

}
