package com.example.hyunndy_01

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        button7.setOnClickListener { view ->

            // 7.
            // setResult()를 통해 resultCode를 전달할 수 있다.
            setResult(Activity.RESULT_OK)
            finish()
        }

        button8.setOnClickListener { view ->
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        button9.setOnClickListener { view ->
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
    }
}
