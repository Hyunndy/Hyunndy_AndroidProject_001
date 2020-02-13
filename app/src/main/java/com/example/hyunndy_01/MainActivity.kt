package com.example.hyunndy_01

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("지존", "현지", "존예")
    var data2 = arrayOf("슬림쿡", "다이어트", "도시락")
    var data3 = intArrayOf(R.drawable.images, R.drawable.images, R.drawable.images)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button8.setOnClickListener { view ->

            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            //리스너 세팅
            //리스트뷰 다이얼로그의 몇번째 항목을 선택했는지가 which에 들어옴
            //버튼들에 세팅하면 이게 몇번째 버튼인지/setItems에 세팅하면 이게 몇번째 항목인지가 들어옴
            var listner =  object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                textView.text = "기본리스트 다이얼로그 :  ${data1[which]}"
            }
        }
            builder.setItems(data1, listner)
            builder.show()

        }

        button.setOnClickListener { view ->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            //심플어댑터 쓰려면 항목 한 칸을 구성하기 위한 항목들을 해쉬맵에 담고, 그 해쉬맵을 리스트에 담고 그 리스트를 심플어댑터에 넣어줘야 한다.
            var list = ArrayList<HashMap<String, Any>>()

            var idx = 0
            while(idx < data2.size)
            {
                var map = HashMap<String, Any>()
                map.put("data2", data2[idx])
                map.put("data3", data3[idx])

                list.add(map)
                idx++

            }

            var keys = arrayOf("data2", "data3")
            var ids = intArrayOf(R.id.textview2, R.id.imageview)

            var adapter = SimpleAdapter(this, list, R.layout.custom_dialogue, keys, ids)


            var listner = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    textView.text = "커스텀 다이얼로그 : ${data2[which]}"
                }
            }

            builder.setAdapter(adapter, listner)




            builder.setNegativeButton("취소", listner)
            builder.show()
        }
    }
}
