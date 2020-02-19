package com.example.hyunndy_01

import android.Manifest
import android.app.*
import android.content.*
import android.content.DialogInterface.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.CalendarContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.sql.Types.NULL
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    // 7. IPC 서비스객체를 받아올 변수
    var ipc_service:ServiceClass1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 3. IPCService를 할 클래스 객체를 Intent에 넣어서 생성
        var intent = Intent(this, ServiceClass1::class.java)

        // 만일 실행중이 아니라면, 실행시킨다.
        if(!isServiceRunning("package com.example.hyunndy_01"))
        {
            startService(intent)
        }

        // 8.
        // 서비스에 접속!
        // bindService()를 안하고 그냥 startService()해버려도 켜지긴하는데 서비스 종료하면 그냥 강제종료되버려서 재접속 시 문제가 생길 수 있으므로 서비스 키고, 서비스에 접속하자.
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

        button.setOnClickListener { view ->
            var value = ipc_service?.getNumber()
            textView.text = "value : ${value}"
        }
    }

    // 9. 서비스 해제
    override fun onDestroy() {
        super.onDestroy()

        unbindService(mConnection)
    }


    // 2.
    // 서비스를 실행시킨다.
    // 현재 실행중인 서비스의 목록을 순회하며 매개변수로 들어간 클래스이름과 같은 서비스가 없다면 return false.
    fun isServiceRunning(name:String):Boolean {
        var manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        // manager.getRunningServices(Int.MAX_VALUE) -> 현재 실행중인 서비스들의 정보가 넘어온다.
        for (service : ActivityManager.RunningServiceInfo in manager.getRunningServices(Int.MAX_VALUE))
        {
            if(service.service.className.equals(name))
            {
                return true
            }
        }
        return false
    }

    // 7. 커넥션 생성
    // 서비스 클래스의 OnBind() 메서드가 반환하는 Binder 객체가 이 OnServiceConnected()에 넘어옵니다.
    private val mConnection = object : ServiceConnection
    {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            // 서비스 객체를 얻어온다!
            val binder = service as ServiceClass1.LocalBinder
            ipc_service = binder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            ipc_service = null
        }
    }
}
