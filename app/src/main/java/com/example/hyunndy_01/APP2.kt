
// APP1의 ContentProvider에 데이터를 요청할 APP2.
// 깃허브 관리하기 귀찮아서 APP2를 임의로 여기다가 넣어놓는다.

/*
package com.example.hyunndy_03

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. SELECT
        // 2. ContentProvider를 통해 Hyunndy_01에서 데이터를 가져온다.
        button.setOnClickListener { view ->

            // 3. ContentProvider의 이름가져오기
            var uri = Uri.parse("content://com.example.dbprovider")

            // 4. ConrentResolver를 통해 쿼리 가져오기.
            var c: Cursor? = contentResolver.query(uri, null, null, null, null)

            textView.text = ""

            // 5.
            // 현재에서 다음 row(열)로 계속 넘어간다. 더이상 접근할게 없으면 false.
            // 각 column(행)의 데이터를 가져오려면 column의 이름을 던져서 해당 컬럼이 몇번째 인덱스인지 받아오고, 그 인덱스가 가진 데이터를 가져와야한다.
            while(c?.moveToNext()!!)
            {

                var idx_pos = c.getColumnIndex("idx")
                var textData_pos = c.getColumnIndex("textData")
                var intData_pos = c.getColumnIndex("intData")
                var floatData_pos = c.getColumnIndex("floatData")
                var DateData_pos = c.getColumnIndex("dataData")

                var idx = c.getInt(idx_pos)
                var textData = c.getString(textData_pos)
                var intData = c.getInt(intData_pos)
                var floatData = c.getDouble(floatData_pos)
                var dateData = c.getString(DateData_pos)

                textView.append("idx : ${idx}\n")
                textView.append("textData : ${textData}\n")
                textView.append("intData : ${intData}\n")
                textView.append("floatData : ${floatData}\n")
                textView.append("dateData : ${dateData}\n")

            }
        }


        // 2. INSERT
        button2.setOnClickListener { view ->

            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            var date = sdf.format(Date())

            // (textData, intData, floatData, dataData) values (?, ?, ?, ?) -> 1:1 배치를 함수로 표현.
            var cv1 = ContentValues()
            cv1.put("textData", "문자열33")
            cv1.put("intData", 100)
            cv1.put("floatData", 11.11)
            cv1.put("dataData", date)

            var cv2 = ContentValues()
            cv2.put("textData", "문자열44")
            cv2.put("intData", 200)
            cv2.put("floatData", 22.22)
            cv2.put("dataData", date)

            var uri = Uri.parse("content://com.example.dbprovider")

            contentResolver.insert(uri, cv1)
            contentResolver.insert(uri, cv2)

        }

        // 3. UPDATE
        button4.setOnClickListener { view ->

            var cv = ContentValues()
            cv.put("textData", "문자열100")
            var where = "idx=?"
            var args = arrayOf("3")

            var uri = Uri.parse("content://com.example.dbprovider")

            // uri 주소, 업데이트할 데이터, 조건절, 조건절에 들어갈 배열
            contentResolver.update(uri, cv, where, args)

            textView.text = "수정 완료"
        }

        // 4. DELETE
        button3.setOnClickListener { view ->

            var where = "idx=?"
            var args = arrayOf("3")

            var uri = Uri.parse("content://com.example.dbprovider")
            contentResolver.delete(uri, where, args)
            textView.text = "삭제완료"
        }




    }
}
*/