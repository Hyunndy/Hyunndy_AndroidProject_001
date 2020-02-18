package com.example.hyunndy_01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


// 1. BR 생성

class TestReceiver : BroadcastReceiver() {

    // 2.
    // 자동으로 호출됨
    // BR은 화면을 처리하는게 아니기때문에 토스트메세지나 노티피케이션을 이용해 메세지를 띄워줘야한다.
    override fun onReceive(context: Context, intent: Intent) {

        var t1 = Toast.makeText(context, "리시버 동작", Toast.LENGTH_SHORT)
        t1.show()
    }
}
