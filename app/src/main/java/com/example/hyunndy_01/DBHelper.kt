package com.example.hyunndy_01

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

// 1. 클래스 생성
// (부모 클래스 4개 생성자)
// name : DB의 이름.
// version : DB파일의 기록. (이전 데이터는 날아가면 안되니까)
// 유지보수 단계에서 DB를 바꿀경우 version 숫자를 바꾸고, 바꾸면 onUpgrade()가 호출된다.
class DBHelper(context : Context) : SQLiteOpenHelper(context, "Test.db", null, 1)
{

    // 2. "Test.db"가 이미 있으면 OnCreate() 바로 호출, 없으면 생성 후 Open() 호출.
    // DB에 들어갈 테이블을 생성하는 함수.
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("test1", "on create")

        // 3. 쿼리문 생성 후 DB에 넣어준다.
        var sql = "create table TestTable (" +
                "idx integer primary key autoincrement, " +
                "textData text not null," +
                "intData integer not null," +
                "floatData real not null," +
                "dataData date not null" +
                ")"

        db?.execSQL(sql)
    }



    // 유지보수 단계에서 DB를 바꿀경우 version 숫자를 바꾸고, 바꾸면 onUpgrade()가 호출된다.
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("test1", "OldBersion : ${oldVersion}, newversion  ${newVersion}")
    }
}