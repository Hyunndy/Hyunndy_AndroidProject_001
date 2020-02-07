package com.example.hyunndy_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("abcd", "On Create");

    }
    override fun  onStart()
    {
        super.onStart();
        Log.d("abcd", "on start");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("abcd", "on restart");
    }

    override fun onResume()
    {
        super.onResume();
        Log.d("abcd", "on Resume");
    }

    override fun onPause() {
        super.onPause();
        Log.d("abcd", "On Pause");
    }

    override fun onStop()
    {
        super.onStop();
        Log.d("abcd", "On Stop");
    }

    override fun onDestroy()
    {
        super.onDestroy();
        Log.d("abcd","On Destroy");
    }
}
