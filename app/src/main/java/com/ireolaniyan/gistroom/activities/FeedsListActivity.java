package com.ireolaniyan.gistroom.activities;

import android.support.v4.app.Fragment;

import com.ireolaniyan.gistroom.fragments.FeedsListFragment;

/**
 * Created by Ire Olaniyan on 11/6/2016.
 */
public class FeedsListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new FeedsListFragment();
    }

}
