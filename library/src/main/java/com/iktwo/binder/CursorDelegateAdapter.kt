package com.iktwo.binder

import android.database.Cursor

class CursorDelegateAdapter(cursor: Cursor? = null, private var cursorTransformer: CursorTransformer? = null) : DelegateAdapter() {
    var cursor: Cursor? = cursor
        private set

    fun swapCursor(cursor: Cursor) {
        if (this.cursor != null) {
            this.cursor!!.close()
        }

        this.cursor = cursor

        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Any? {
        return if (cursor!!.moveToPosition(position)) {
            cursorTransformer!!.transform(cursor!!)
        } else {
            null
        }
    }

    override fun getItemCount(): Int {
        return if (cursor != null) cursor!!.count else 0
    }
}
