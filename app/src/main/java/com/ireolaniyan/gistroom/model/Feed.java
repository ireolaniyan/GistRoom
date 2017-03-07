package com.ireolaniyan.gistroom.model;

import java.util.UUID;

/**
 * Created by Ire Olaniyan on 11/2/2016.
 */
public class Feed {
    private UUID mId;
    private String mFeed;
    private boolean mStarred;
//    private Image mImage;

    public Feed() {
        // Generate unique identifier.
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getFeed() {
        return mFeed;
    }

    public void setFeed(String feed) {
        mFeed = feed;
    }

/*    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }*/

    public boolean isStarred() {
        return mStarred;
    }

    public void setStarred(boolean starred) {
        mStarred = starred;
    }
}