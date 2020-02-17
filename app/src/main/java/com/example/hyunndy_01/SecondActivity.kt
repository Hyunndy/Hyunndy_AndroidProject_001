package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 4.
        // 버튼을 누르면 현재 실행중인 Activity를 종료 시킨다.
        // 만일 Back Stack에 이전 Activity가 남아있으면 지금건 종료되고 이전것이 실행된다.
        // 따라서 main -> second -> finsh순으로 왔으니 이 버튼을 누르면 Back stack에 남아있는 main으로 갈 것이다.
        // 하지만 main에서 버튼을 하나 추가해서 finish를 하면 Back Stack에 아무것도 없기 때문에 app이 바로 종료될것이다.
        // 하지만 main에서 버튼을 하나 추가해서 finish를 하면 Back Stack에 아무것도 없기 때문에 app이 바로 종료될것이다.
        button.setOnClickListener { view ->
            finish()
        }
    }
}
