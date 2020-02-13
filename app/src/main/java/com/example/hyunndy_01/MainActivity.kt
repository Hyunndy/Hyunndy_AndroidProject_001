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

     var data1 = arrayOf("지존", "현지", "존예")
     //var data2 = arrayOf("슬림쿡", "다이어트", "도시락")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 버튼을 클릭하면 텍스트뷰에 팝업 메뉴를 띄우는 형식.
        button.setOnClickListener { view ->
            var pop = PopupMenu(this, textView)

            //팝업 메뉴 생성
            menuInflater.inflate(R.menu.popup_menu, pop.menu)

            // 팝업 메뉴에 리스너 설정(중첩 클래스)
            var listner = PopupListner()
            pop.setOnMenuItemClickListener(listner)

            // 팝업 메뉴에 리스너 설정(람다식)
            // 람다식에서의 return 값은 밑에 false를 넣어주면 알아서 그 값만 들어간다.
            pop.setOnMenuItemClickListener { item ->
                when(item?.itemId)
                {
                    R.id.item1 ->
                        textView.text = "지존"
                    R.id.item2 ->
                        textView.text = "존예"
                    R.id.item3 ->
                        textView.text = "현지"
                }
                false
            }
            //팝업 메뉴 SHOW
            pop.show()
        }
    }

    inner class PopupListner:PopupMenu.OnMenuItemClickListener{
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId)
            {
                R.id.item1 ->
                    textView.text = "지존"
                R.id.item2 ->
                    textView.text = "존예"
                R.id.item3 ->
                    textView.text = "현지"
            }
            return true
        }
    }
}