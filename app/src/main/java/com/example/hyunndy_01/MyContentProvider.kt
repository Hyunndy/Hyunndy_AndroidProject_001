package com.example.hyunndy_01

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        // Implement this to handle requests to delete one or more rows.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        return db.delete("TestTable", selection, selectionArgs)
    }

    override fun getType(uri: Uri): String? {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw UnsupportedOperationException("Not yet implemented")
    }

    // 2. INSERT
    // ContentValues에 저장할 데이터와 칼럼들을 세팅한다음에 넘겨주면된다.
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        // TODO: Implement this to handle requests to insert a new row.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        db.insert("TestTable", null, values)

        return uri
    }

    override fun onCreate(): Boolean {
        // TODO: Implement this to initialize your content provider on startup.
        return false
    }

    // 1. SELECT
    // projection : 가져올 Column의 이름
    // selection : 조건절
    // selectionArgs : 조건절에 들어갈 배열
    // sortOrder : 정렬
    // 반환타입 : Cursor(DB에 있는 데이터를 가져와서 쓸 수 있는 형식)
    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        // TODO: Implement this to handle query requests from clients.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        return db.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)

    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        // TODO: Implement this to handle requests to update one or more rows.

        var helper =  DBHelper(context)
        var db = helper.writableDatabase

        return db.update("TestTable", values, selection, selectionArgs)
    }
}
