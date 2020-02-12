package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("지존", "현지", "존예")
    var data2 = arrayOf("슬림쿡", "다이어트", "도시락")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var adpater = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner.adapter = adpater
        spinner2.adapter = adapter2

        // inner 클래스
        var listener = SpinnerListener()
        spinner.onItemSelectedListener = listener

        // 익명 중첩 클래스
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textView.text = data2[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        button.setOnClickListener {view ->
            textView.text = data1[spinner.selectedItemPosition] + "\n"
            textView.append(data2[spinner2.selectedItemPosition])

        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener
    {
        // position 이 사용자가 선택한 항목의 인덱스
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data1[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}