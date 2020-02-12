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
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

   // var data1 = arrayOf("지존", "현지", "존예")
    //var data2 = arrayOf("슬림쿡", "다이어트", "도시락")


    //1. 뷰들을 담을 리스트
    var view_list = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. 뷰리스트에 add.
        view_list.add(layoutInflater.inflate(R.layout.view1,null))
        view_list.add(layoutInflater.inflate(R.layout.view2,null))
        view_list.add(layoutInflater.inflate(R.layout.view3,null))

        viewpager.adapter = CustomAdapter()

        // 리스너 익명 중첩 클래스
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            // 스크롤 상태가 변경되었을 때
            override fun onPageScrollStateChanged(state: Int) {

            }


            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                textView.text = "${position} 번째 뷰가 나타났습니다"
            }

            // 클릭했을 때 반응
            override fun onPageSelected(position: Int) {

            }
            })
    }

    inner class CustomAdapter : PagerAdapter()
    {
        override fun getCount(): Int {
            return view_list.size
        }

        // 현재 객체가 보여줄 객체와 일치 하는지!
        // 코틀린은 저 따옴표로 키워드를 생성할 수 있다.
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        // 항목을 구성하기 위해 호출하는 함수.
        // 보여주고자 하는 항목을 Pager 객체에 넣고 반환해주면된다.
        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            // 이 함수 다음에 isViewFromObject()가 호출이 되서,
            // 이게 첫번째 인자, return 값이 2번째 인자로 들어간다.
            viewpager.addView(view_list[position])

            return view_list[position]
        }

        // 더이상 안보여지는 항목을 없애주는 메소드.
        // 이게 없으면 정상 작동x
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewpager.removeView(`object` as View)
            //obj를 View로 형변환하고 제거해라.
        }
    }

}