package com.iktwo.sample;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DirectoryDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "directory.db";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_CLIPBOARD = String.format("CREATE TABLE IF NOT " +
                    "EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL unique)",
            DatabaseContract.TABLE_CLIPBOARD,
            DatabaseContract.ClipboardColumns._ID,
            DatabaseContract.ClipboardColumns.CONTENT
    );

    public DirectoryDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CLIPBOARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_CLIPBOARD);

        onCreate(db);
    }
}
