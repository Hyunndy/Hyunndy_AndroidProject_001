package com.example.hyunndy_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

     var data1 = arrayOf("지존", "현지", "존예")
     //var data2 = arrayOf("슬림쿡", "다이어트", "도시락")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. 기본 토스트 메세지 출력
        button2.setOnClickListener { view ->
            var t1 = Toast.makeText(this, "토스트 메세지 입니다.", Toast.LENGTH_LONG)
            t1.show()
        }

        button3.setOnClickListener { view ->
            // 1. 토스트 객체를 통해 보여줄 View생성
            var v1 = layoutInflater.inflate(R.layout.custom_toast, null)

            // 4. 배경을 바꿔보자
            v1?.setBackgroundResource(android.R.drawable.toast_frame)

            // 2. 이미지를 바꿔보자~!
            var image_view:ImageView? = v1.findViewById<ImageView>(R.id.imageView)
            image_view?.setImageResource(R.drawable.off)

            // 3. 텍스트를 바꿔보자!
            var text_view: TextView? = v1.findViewById<TextView>(R.id.textView)
            text_view?.text = ("꿰에에에에엑")
            text_view?.setTextColor(Color.WHITE)

            var t2 = Toast(this)
            t2.view = v1

            // 5. 토스트 메세지 위치를 바꿔보자!
            t2.setGravity(Gravity.CENTER, 0, 0)


            t2.show()
        }
    }

}