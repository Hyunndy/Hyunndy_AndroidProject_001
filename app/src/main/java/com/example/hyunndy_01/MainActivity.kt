package com.example.hyunndy_01

import android.Manifest
import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    // 1. 등록한 권한들 중에서 확인이 필요한 권한들만 목록으로 코드로 짜주면 된다.
    var permission_list = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.SEND_SMS
    )

    // 2. 권한 확인(안드로이드 마쉬멜로우 이상 버전에서부터만 검사한다)
    fun checkPermission(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {
            return
        }
        else
        {
            // Kotlin에서의 for문은 배열을 도는 용도.
            for(permission : String in permission_list)
            {
                // 권한 허용했는지 묻는 용도(INT)
                var chk = checkCallingOrSelfPermission(permission)

                // 만일 거절했었다면,
                if(chk == PackageManager.PERMISSION_DENIED)
                {
                    // 권한 승인 요청
                    requestPermissions(permission_list, 0)

                    break
                }
            }
        }
    }

    // 3. 권한 승인 요청 후 다이얼로그 없어졌을 때 어떤 권한들이 승인되었는지 알아보는 함수
    // permissions : 체크한 권한들의 목록 배열
    // grantResults : 해당 배열이 승인되었는지 안되었는지 여부
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        var idx = 0;

        // indices를붙으면 배열의 인덱스 번호,
        // 안붙이면 배열의 값.
        for(idx in grantResults.indices)
        {
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED)
            {
                textView.append("${permission_list[idx]} : 허용함\n")
            }
            else
            {
                textView.append("${permission_list[idx]} : 거부함\n")
            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }
}
