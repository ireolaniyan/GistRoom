package com.ireolaniyan.gistroom.database;

/**
 * Created by Ire Olaniyan on 11/12/2016.
 */
public class FeedsDbSchema {
    public static final class FeedTable{
//        The FeedTable class only exists to define the String constants needed to describe the moving pieces
//        of your table definition.

//        The first piece of that definition is the name of the table in your database,
//        FeedTable.NAME.
        public static final String NAME = "feeds";

//         Describing the columns of the table
        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String STARRED = "starred";
        }
    }
}
