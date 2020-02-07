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

        button.setOnClickListener { view ->
            progressBar.incrementProgressBy(5);
            progressBar2.incrementProgressBy(5);
            progressBar3.incrementProgressBy(5);
            progressBar4.incrementProgressBy(5);
        }
    }
}
