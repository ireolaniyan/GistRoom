package com.ireolaniyan.gistroom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ireolaniyan.gistroom.database.FeedsBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ire Olaniyan on 11/2/2016.
 */
public class FeedsLab {
    private static FeedsLab sFeedsLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static FeedsLab get(Context context){
        if (sFeedsLab == null){
            sFeedsLab = new FeedsLab(context);
        }
        return sFeedsLab;
    }


    private FeedsLab(Context context){
//        Opening the SQLiteDatabase
        mContext = context.getApplicationContext();
        mDatabase = new FeedsBaseHelper(mContext).getWritableDatabase();
        /* When you call getWritableDatabase()here, FeedsBaseHelper will do the following:
        1. Open up /data/data/com.ireolaniyan.gistroom/databases/feedsBase.db,
        creating a new database file if it does not already exist.
        2. If this is the first time the database has been created, call onCreate(SQLiteDatabase), then save
        out the latest version number.
        3. If this is not the first time, check the version number in the database. If the version number in
        FeedsOpenHelper is higher, call onUpgrade(SQLiteDatabase, int, int).
*/
    }

    public List<Feed> getFeeds(){
        return new ArrayList<>();
    }

    public Feed getFeed(UUID id){
        return null;
    }
}
