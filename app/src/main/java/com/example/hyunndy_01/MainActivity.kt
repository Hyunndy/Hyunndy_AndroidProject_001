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

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        listview.adapter = adapter

        listview.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${position} 번째 항목을 터치했습니다."
        }


        // 1. 컨텍스트 메뉴를 뷰에 세팅
        registerForContextMenu(textView)
        registerForContextMenu(listview)
    }


    // 두번째 매개변수가 유저가 길게 누른 View.
    // 만약에 리스트뷰의 항목마다 컨텍스트메뉴를 다르게 가고싶다면, 선택한 항목이 리스트뷰의 몇번째 항목인지는 menuInfo 매개변수로 넝머온다.
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when(v?.id)
        {
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴") // 컨텍스트뷰의 제목
                menuInflater.inflate(R.menu.textview_menu, menu) // xml파일로 만들어준 menu
            }
            R.id.listview ->
            {
                menu?.setHeaderTitle("리스트뷰의 메뉴")
                menuInflater.inflate(R.menu.listview_menu,menu)

                // 사용자가 길게누른 리스트뷰의 항목
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
                if(info.position % 2 == 0)
                {
                    // 짝수번째 리스트뷰 항목을 눌렀을 때 메뉴를 3개로 추가시킨다.
                    menu?.add(Menu.NONE, Menu.FIRST + 100, Menu.NONE, "리스트뷰 메뉴3")
                }
            }

        }
    }

    // 사용자가 길게 누른 View객체의 주소값이 넘어오지 않는다.
    // 따라서 메뉴 아이템의 id값을 다 다르게 만들어야 여기서도 알 수 있다.

    // 이 함수에서 사용자가 누른 리스트뷰가 몇 번째 항목인지 알려면!
    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item?.itemId)
        {
            R.id.textview_Item1 ->
                textView.text = "존예"
            R.id.textview_Item2 ->
                textView.text = "지존"
            R.id.listview_item1 ->
            {
                textView.text = "리스트뷰_존예"

                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position}째 항목")
            }

            R.id.listview_item2 ->
            {
                textView.text = "리스트뷰_지존"
                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                textView.append("${info.position}째 항목")
            }
        }

        return super.onContextItemSelected(item)
    }
}