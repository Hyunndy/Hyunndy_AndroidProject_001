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
    }

    // 1. 메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // 3. searchView의 기본 text 바꾸기
        // 서치로 사용되는 메뉴의 항목(item) 가져오기.
        var search_item:MenuItem? = menu?.findItem(R.id.tiem5)
        // 서치뷰 가져오기.
        var search_view:SearchView = search_item?.actionView as SearchView
        // 쿼리 힌트를 내가 원하는걸 하기.
        search_view.queryHint = "검색어를 입력해주세요"



        // 4. 검색완료 버튼 눌렀을 떄의 처리
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            // 검색창에 들어오는 텍스트
            override fun onQueryTextChange(newText: String?): Boolean {
                textView.text = newText

                // 키보드가 내려가는지 안내려가는지 결정
                return false
            }

            // 검색창에 텍스트 치고 검색완료 버튼 눌러서 Submit했을 때의 반응
            override fun onQueryTextSubmit(query: String?): Boolean {
                textView2.text = query

                // 키보드가 내려가는지 안내려가는지 결정
                // false면 검색완료 누르면 내려감
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    // 2. 옵션 메뉴 설정
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item1 ->
                textView.text = "지존"
            R.id.tiem2 ->
                textView.text = "존예"
            R.id.tiem3 ->
                textView.text = "현지"
            R.id.tiem4 ->
                textView.text = "존못"
        }

        return super.onOptionsItemSelected(item)
    }
}