package com.ireolaniyan.gistroom.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ireolaniyan.gistroom.database.FeedsDbSchema.FeedTable;

/**
 * Created by Ire Olaniyan on 11/12/2016.
 */
public class FeedsBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "feedsBase.db";

    public FeedsBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

//    Create the initial database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + FeedTable.NAME + "(" +
                    "_id integer primary key autoincrement, " +
                    FeedTable.Cols.UUID + ", " +
                    FeedTable.Cols.TITLE + ", " +
                    FeedTable.Cols.DATE + ", " +
                    FeedTable.Cols.STARRED +
                    ")"
        );
    }

//    Handle any upgrades
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
