package com.iktwo.binder;

import android.database.Cursor;

public interface CursorTransformer {
    Object transform(Cursor cursor);
}
