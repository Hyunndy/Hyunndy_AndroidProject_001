package com.example.hyunndy_01

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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

   // var data1 = arrayOf("지존", "현지", "존예")
    //var data2 = arrayOf("슬림쿡", "다이어트", "도시락")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //1. xml로 메뉴 생성 메뉴 생성은 menuInflater
       // menuInflater.inflate(R.menu.optionmenu, menu)


        //2. 코드로 생성하기.
        menu?.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드메뉴1");
        menu?.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드메뉴1");

        var sub:Menu? = menu?.addSubMenu("메뉴3")
        sub?.add(Menu.NONE, Menu.FIRST + 3, Menu.NONE, "코드메뉴 3-1")
        sub?.add(Menu.NONE, Menu.FIRST + 4, Menu.NONE, "코드메뉴 3-1")


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /* 1. XML로 구현하기
        when(item?.itemId)
        {
            R.id.Item2_1 ->
                textView.text = "우루룰ㄹ";
            R.id.Item2_2 ->
                textView.text = "에렐레렐";
        }
        */

        when(item?.itemId)
        {
            Menu.FIRST + 1 ->
                textView.text = "우루룰ㄹ";
            Menu.FIRST + 2 ->
                textView.text = "에렐렐ㄹㄹ";
            Menu.FIRST + 3->
                textView.text = "뷁뷁";
        }


        return super.onOptionsItemSelected(item)
    }
}