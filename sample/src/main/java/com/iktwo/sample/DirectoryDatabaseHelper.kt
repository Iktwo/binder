package com.iktwo.sample

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DirectoryDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_CLIPBOARD)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_CLIPBOARD)

        onCreate(db)
    }

    companion object {
        private val DB_NAME = "directory.db"
        private val DB_VERSION = 1

        private val SQL_CREATE_CLIPBOARD = String.format("CREATE TABLE IF NOT " + "EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL unique)",
                DatabaseContract.TABLE_CLIPBOARD,
//                DatabaseContract.ClipboardColumns._ID,
                DatabaseContract.ClipboardColumns.CONTENT
        )
    }
}
