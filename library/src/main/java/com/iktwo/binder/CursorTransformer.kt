package com.iktwo.binder

import android.database.Cursor

interface CursorTransformer {
    fun transform(cursor: Cursor): Any
}
