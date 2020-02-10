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


    // 안드로이드는 res폴더에 들어있는 리소스를 사용할 때 리소스 id라는 개념을 사용하게 된다. 즉, int형 자료.

    // id, int형 배열.
    var imgRes = intArrayOf(R.drawable.images, R.drawable.off)

    var data1 = arrayOf("인어공주", "꿈속의 마니");
    var data2 = arrayOf("mermaid", "mani");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 심플 어댑터 구조
        // 항목 하나를 구성할 개체들을 hashmap 객체에 담은 다음에 그걸 arraylist에 담고 어댑터에 세팅한다.

        // any = 어떠한 값이나 다 넣을 수 있다. 위에 넣을 애들이 정수형or문자열이므로 Any을 넣고, 만약 통일되었을 경우 그 자료형을 넣으면 된다.
        var list = ArrayList<HashMap<String, Any>>()


        //2.데이터 담기
        var idx = 0
        while(idx < imgRes.size)
        {
            var map = HashMap<String, Any>()

            map.put("flag", imgRes[idx]);
            map.put("data1", data1[idx]);
            map.put("data2", data2[idx]);

            list.add(map)
            idx++
        }


        //데이터 세팅
        var keys = arrayOf("flag", "data1", "data2");
        var ids = intArrayOf(R.id.imageView2, R.id.textView2, R.id.textView3);

        var adaptor = SimpleAdapter(this, list, R.layout.row, keys, ids)
        listview.adapter = adaptor



        //리스너
        listview.setOnItemClickListener { parent, view, position, id ->
            textView.text = data1[position]
        }

    }
}