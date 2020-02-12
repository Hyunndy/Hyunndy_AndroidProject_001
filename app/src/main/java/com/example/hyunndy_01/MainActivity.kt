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
import kotlinx.android.synthetic.main.row.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1", "데이터2", "데이터3");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //data에 들어있는 항목들을 리스트뷰 항목 하나하나에 넣어주는것(문자열만 있는 경우)
       // var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.textView2, data);
        var adapter = ListAdapter();
        listview2.adapter = adapter;


        //버튼을 누르면 이벤트가 발생하게 하기위해 어뎁터를 새로 만든다.
    }

    inner class ListAdapter : BaseAdapter()
    {

        var listner = BtnListenr();

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        /*
        리스트 뷰 항목 하나를 구성하기 위해 호출되는 메서드.
        이 함수로 리턴되는 View로 리스트뷰 항목 하나를 구성.

        예를들어 100만개의 항목 중 7개만 화면에 보인다고 하면 초기화 시에 7번 호출되었다가
        스크롤 내리면서 새롭게 나타나는것만큼 그 항목을 구성하기 위해 호출된다.
        이 때 보였다가 안보이게된 View는 재사용성을 위해 2번째 인자인 convertView로 넘어온다.

        convertView가 null이 아니라면 재사용 가능, 없다면 layoutInflater로 생성해준다.
        */

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var p1:View? = convertView

            // 재사용가능성이 있는 뷰가 null이면 재사용할 수 있는게 없기 때문에 R.layout.row로 만들어주고,
            // 만약에 null이 아니고 넘어오면, 다시 만들어올 필요가 없음.
            if(p1 == null)
            {
                p1 = layoutInflater.inflate(R.layout.row, null)
            }

            //텍스트뷰를 반환하고
            var textView:TextView? = p1?.findViewById<TextView>(R.id.textView2)
            var button1:Button? = p1?.findViewById<Button>(R.id.button);
            var button2:Button? = p1?.findViewById<Button>(R.id.button2);


            // 예제에서 n번째 버튼이 눌리면 발생하는 이벤트를 만들고싶은데,
            // 안드로이드OS가 이게 몇번째 버튼인지 알 수 있는 방법이 없다.
            // 따라서 이 함수에서 ButtonView의 tag 항목에 이 버튼이 리스트뷰의 몇번째 항목인지 전달해준다.

            // 버튼 객체 안에다가 tag 항목을 넣어놨기 때문에
            // 리스너의 OnClick()에서 넘어가는 ButtonView에 tag값으로 보내준다.
            button1?.tag = position
            button2?.tag = position


            button1?.setOnClickListener(listner);
            button2?.setOnClickListener(listner);


            // 항목의 인덱스 번호를 텍스트에 넣고
            textView?.text = data[position]

            //항목을 반환
            return p1
        }
    }

    inner class BtnListenr:View.OnClickListener{

        override fun onClick(v: View?) {

            var position = v?.tag as Int

            when (v?.id) {
                R.id.button ->
                    textView.text = "${position} = 첫번째 버튼 클릭\n"
                R.id.button2 ->
                    textView.text = "${position} = 두번째 버튼 클릭\n"
            }
        }
    }
}