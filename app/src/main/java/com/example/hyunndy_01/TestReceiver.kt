package com.example.hyunndy_01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.widget.Toast


// 1. BR 생성
class TestReceiver : BroadcastReceiver() {

    // 2.
    // 자동으로 호출됨
    // BR은 화면을 처리하는게 아니기때문에 토스트메세지나 노티피케이션을 이용해 메세지를 띄워줘야한다.
    override fun onReceive(context: Context, intent: Intent) {


        // 3. 하나의 리시버에서 다중의 메세지를 처리하려면 분기별로 나눠야하는데, 그 정보는 intent가 갖고있다.
        when(intent.action)
        {
            // 4. 재부팅 완료 브로드캐스트(암시적 인텐트).
            //"android.intent.action.BOOT_COMPLETED" ->
            Intent.ACTION_BOOT_COMPLETED ->
            {
                var t1 = Toast.makeText(context, "부팅 완료", Toast.LENGTH_SHORT)
                t1.show()
            }
           // "android.provider.Telephony.SMS_RECEIVED" ->
            Telephony.Sms.Intents.SMS_RECEIVED_ACTION ->
            {
                // 5.
                // 문자 메세지를 받으면 토스트메시지로 (발신자 : 문자 내용)이 뜨는 코드.
                // bundle안에 pdus라는 이름으로 문자메세지 정보가 들어가있다.
                var str = ""
                var bundle = intent.extras
                if(bundle != null)
                {
                    var obj = bundle.get("pdus") as Array<Any>
                    var msg = arrayOfNulls<SmsMessage>(obj.size)

                    for (i in obj.indices)
                    {
                        msg[i] = SmsMessage.createFromPdu(obj[i] as ByteArray)
                    }

                    // 6. 문자 발신자 전화번호를 뽑음.
                    for (i in msg.indices)
                    {
                        str = msg[i]?.originatingAddress + " : " + msg[i]?.messageBody
                        var t2 = Toast.makeText(context, str, Toast.LENGTH_SHORT)
                        t2.show()
                    }
                }
            }
        }
    }
}
