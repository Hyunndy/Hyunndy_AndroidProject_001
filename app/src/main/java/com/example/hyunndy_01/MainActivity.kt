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

        // 1.안드로이드가 알고있는 레이아웃을 할때는 레이아웃, 데이터만 전달해줘도된다.
        // 2. 하지만 내가 만든 레이아웃(row1)을 사용할 때는 이 데이터를 넣을 곳(리스트항목)의 id를(textview2) 안드로이드 OS에게 알려줘야한다.
        var adater = ArrayAdapter(this, R.layout.row1, R.id.textview2,data);
        listview.adapter = adater;


        //3.
        //리스너 : 리스트의 항목을 터치하면 발생하는 리스너
        var listner = ListListener();
        listview.setOnItemClickListener(listner);

        listview.setOnItemClickListener { parent, view, position, id ->
        //    textView.text = data[position]
        }
    }

    inner class ListListener : AdapterView.OnItemClickListener
    {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //    textView.text = data[position];
        }
    }
}