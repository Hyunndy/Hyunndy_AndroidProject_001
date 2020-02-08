package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //오버라이딩 할 함수가 1개라면 람다식으로 하는게 좋지만,
        seekBar.setOnSeekBarChangeListener( view ->

        )


        //오버라이딩 할 함수가 2개 이상이라면 익명 중첩 클래스를 이용하는게 좋다.
        seekBar2.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        var listener2 = SeekListener();
        seekBar.setOnSeekBarChangeListener(listner2);
    }

    inner class SeekListener:SeekBar.OnSeekBarChangeListener
    {

        // SeekBar 값이 변경되었을 때(코드로 바꾼경우, 유저에 의해 바뀐 경우)
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        }

        // 값을 변경하기 위해 사용자가 터치했을 때
        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        // 값을 변경한 후 터치를 때었을 때
        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            4
        }
    }
}