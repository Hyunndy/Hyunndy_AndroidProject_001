package com.example.hyunndy_01

import android.content.*
import android.database.Cursor
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->

            // 5. DB 오픈
           var helper = DBHelper(this)
           var db = helper.writableDatabase

            // 1. 클래스를 이용하는 방법 - INSERT
            var sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            var date = sdf.format(Date())

            // (textData, intData, floatData, dataData) values (?, ?, ?, ?) -> 1:1 배치를 함수로 표현.
            var cv1 = ContentValues()
            cv1.put("textData", "문자열1")
            cv1.put("intData", 100)
            cv1.put("floatData", 11.11)
            cv1.put("dataData", date)

            var cv2 = ContentValues()
            cv2.put("textData", "문자열2")
            cv2.put("intData", 200)
            cv2.put("floatData", 22.22)
            cv2.put("dataData", date)

            db.insert("TestTable", null, cv1)
            db.insert("TestTable", null, cv2)
            db.close()

            textView.text = "저장 완료"
        }

        // 7. 데이터 가져오기
        button2.setOnClickListener { view ->

            var helper = DBHelper(this)
            var db = helper.writableDatabase

            var sql = "select * from TestTable"

            // 커서 클래스타입의 객체는 select해서 가져올 수 있는 객체의 클래스 타입이다.
            var c: Cursor = db.rawQuery(sql, null)

            textView.text = ""

            // 현재에서 다음 row(열)로 계속 넘어간다. 더이상 접근할게 없으면 false.
            // 각 column(행)의 데이터를 가져오려면 column의 이름을 던져서 해당 컬럼이 몇번째 인덱스인지 받아오고, 그 인덱스가 가진 데이터를 가져와야한다.
            while(c.moveToNext())
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

            db.close()
        }

        // 8. 데이터 업데이트
        button3.setOnClickListener { view ->
            var helper = DBHelper(this)
            var db = helper.writableDatabase

            var sql = "update TestTable set textData=? where idx=?"
            var args = arrayOf("문자열3", "1")
            db.execSQL(sql, args)

            db.close()

            textView.text = "수정 완료"
        }

        // 9. 데이터 삭제
        button4.setOnClickListener { view ->
            var helper = DBHelper(this)
            var db = helper.writableDatabase

            var sql = "delete from TestTable where idx =?"
            var args = arrayOf("1")

            db.execSQL(sql, args)
            db.close()

            textView.text = "삭제완료"
        }
        
    }
}
