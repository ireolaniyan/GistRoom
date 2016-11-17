package com.ireolaniyan.gistroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.ireolaniyan.gistroom.database.FeedsBaseHelper;
import com.ireolaniyan.gistroom.database.FeedsDbSchema;
import com.ireolaniyan.gistroom.database.FeedsDbSchema.FeedTable;

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

//    Adding rows to the database.
    public void addFeed(Feed f){
        ContentValues values = getContentValues(f);
        mDatabase.insert(FeedTable.NAME, null, values);
    }

    public List<Feed> getFeeds(){
        return new ArrayList<>();
    }

    public Feed getFeed(UUID id){
        return null;
    }

    public void updateFeed(Feed feed){
        String uuidString = feed.getId().toString();
        ContentValues values = getContentValues(feed);

    }

//    ContentValues method Handles writes and updates to database.
//    Shuttling a Feed into a ContentValues
    private static ContentValues getContentValues(Feed feed){
        ContentValues values = new ContentValues();
        values.put(FeedTable.Cols.UUID, feed.getId().toString());
//        values.put(FeedTable.Cols.STARRED, feed.isStarred() ? 1 : 0);
        values.put(FeedTable.Cols.FEED, feed.getFeed());

        return values;
    }
}
