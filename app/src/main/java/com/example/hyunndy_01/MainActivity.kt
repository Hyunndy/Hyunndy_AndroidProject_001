package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    // 1.
    // 코틀린의 배열은 arrayOf
    var data = arrayOf("리스트1", "리스트2", "리스트3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2.
        //컨텍스트 : 어떠한 작업을 위해 필요한것들이 담아져있는 것.
        // 안드로이드 컨텍스트 화면에 필요한것, OS 등
        // 컨텍스트, 레이아웃,
        var adater = ArrayAdapter(this, android.R.layout.simple_list_item_1 , data);
        listview.adapter = adater;


        //3.
        //리스너 : 리스트의 항목을 터치하면 발생하는 리스너
        var listner = ListListener();
        listview.setOnItemClickListener(listner);

        listview.setOnItemClickListener { parent, view, position, id ->
            textView.text = data[position]
        }
    }

    inner class ListListener : AdapterView.OnItemClickListener
    {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            textView.text = data[position];
        }
    }
}