package com.iktwo.sample

import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {
    val TABLE_CLIPBOARD = "clipboard"
    val CONTENT_AUTHORITY = "com.iktwo.sample"

    val CONTENT_URI = Uri.Builder().scheme("content")
            .authority(CONTENT_AUTHORITY)
            .appendPath(TABLE_CLIPBOARD)
            .build()

    fun getColumnString(cursor: Cursor, columnName: String): String {
        return cursor.getString(cursor.getColumnIndex(columnName))
    }

    class ClipboardColumns : BaseColumns {
        companion object {
            val CONTENT = "content"
        }
    }
}