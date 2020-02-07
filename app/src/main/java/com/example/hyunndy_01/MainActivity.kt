package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        button.setOnClickListener { view ->

            when (RadioGroup.checkedRadioButtonId) {
                R.id.radioButton ->
                    textView.text = "눈";
                R.id.radioButton2 ->
                    textView.text = "코";
                R.id.radioButton3 ->
                    textView.text = "입";
            }

            when (RadioGroup2.checkedRadioButtonId) {
                R.id.radioButton4 ->
                    textView2.text = "팔";
                R.id.radioButton5 ->
                    textView2.text = "다리";
                R.id.radioButton6 ->
                    textView2.text = "허리";
            }
        }
        */


       // var Listener2 = RadioListener();
       // RadioGroup.setOnCheckedChangeListener(Listener2);
       // RadioGroup2.setOnCheckedChangeListener(Listener2);

        RadioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId)
            {
                R.id.radioButton->
                    textView.text = "체크 이벤트 : 눈";
                R.id.radioButton2->
                    textView.text = "체크 이벤트 : 코";
                R.id.radioButton3->
                    textView.text = "체크 이벤트 : 입";
            }
        }

        RadioGroup2.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId)
            {
                R.id.radioButton->
                    textView2.text = "체크 이벤트 : 눈";
                R.id.radioButton2->
                    textView2.text = "체크 이벤트 : 코";
                R.id.radioButton3->
                    textView2.text = "체크 이벤트 : 입";
            }
        }

    }

    inner class RadioListener:RadioGroup.OnCheckedChangeListener
    {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when(group?.id)
            {
                R.id.RadioGroup ->
                    when(checkedId)
                    {
                        R.id.radioButton->
                            textView.text = "체크 이벤트 : 눈";
                        R.id.radioButton2->
                            textView.text = "체크 이벤트 : 코";
                        R.id.radioButton3->
                            textView.text = "체크 이벤트 : 입";
                    }
                R.id.RadioGroup2 ->
                    when(checkedId) {
                        R.id.radioButton4 ->
                            textView2.text = "체크 이벤트 : 허리";
                        R.id.radioButton5 ->
                            textView2.text = "체크 이벤트 : 다리";
                        R.id.radioButton6 ->
                            textView2.text = "체크 이벤트 : 팔";
                    }
            }
        }
    }
}
