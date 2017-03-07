package com.ireolaniyan.gistroom.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.ireolaniyan.gistroom.fragments.FeedsFragment;

import java.util.UUID;

public class FeedsActivity extends SingleFragmentActivity {

    private static final String EXTRA_FEED_ID =
            "com.ireolaniyan.gistroom.feed_id";

    /* Tells FeedsFragment which Feed to display by passing the feed ID as an Intent extra when
        FeedsActivity is started.
    */
    public static Intent newIntent(Context packageContext, UUID feedId) {
        Intent intent = new Intent(packageContext, FeedsActivity.class);
        intent.putExtra(EXTRA_FEED_ID, feedId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
//        return new FeedsFragment();
        UUID feedId = (UUID) getIntent().getSerializableExtra(EXTRA_FEED_ID);
        return FeedsFragment.newInstance(feedId);
    }
}
