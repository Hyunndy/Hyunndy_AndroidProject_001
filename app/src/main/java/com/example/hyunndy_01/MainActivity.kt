package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            textView6.text = " ";

            if(checkBox.isChecked)
            {
                //문자열 뒤에 추가적으로 붙게 되는것.
                textView6.append("현지는 존예이다\n");
            }
            if(checkBox2.isChecked)
            {
                textView6.append("현지는 지존이다\n");
            }
            if(checkBox3.isChecked)
            {
                textView6.append("거짓입니다.\n");
            }
        }


        button2.setOnClickListener { view ->
            checkBox.isChecked = true;
            checkBox2.isChecked = true;
            checkBox3.isChecked = true;
        }

        button3.setOnClickListener { view ->
            checkBox.toggle();
            checkBox2.toggle();
            checkBox3.toggle();
        }

        var listener2 = CheckBoxListener();
        checkBox.setOnCheckedChangeListener(listener2);

        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
            {
                textView6.text = ("이벤트 : 체크박스 2가 체크되었습니다.");
            }
            else
            {
                textView6.text = ("이벤트 : 체크박스 2가 체크되지않았습니다.");
            }
        }

        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
            {
                textView6.text = ("이벤트 : 체크박스 3가 체크되었습니다.");
            }
            else
            {
                textView6.text = ("이벤트 : 체크박스 3가 체크되지않았습니다.");
            }
        }

    }

    inner class CheckBoxListener:CompoundButton.OnCheckedChangeListener
    {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if(isChecked)
            {
                textView6.text = "이벤트 : 체크박스 1이 체크되었다.";
            }
            else
            {
                textView6.text = "이벤트 : 체크박스 1이 해제되었다.";
            }
        }
    }
}
