package com.ireolaniyan.gistroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Ire Olaniyan on 11/2/2016.
 */
public class FeedsFragment extends Fragment {
    private static final String ARG_FEED_ID = "feed_id";

    private Feed mFeed;
    private TextView mFeedView;

    public FeedsFragment() {
        // Required empty public constructor
    }

    public static FeedsFragment newInstance(UUID feedId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FEED_ID, feedId);
        FeedsFragment fragment = new FeedsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFeed = new Feed();

        UUID feedId = (UUID) getArguments().getSerializable(ARG_FEED_ID);
        mFeed = FeedsLab.get(getActivity()).getFeed(feedId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feed, container, false);
        // Inflate the layout for this fragment
        mFeedView = (TextView)v.findViewById(R.id.feed_textView);
        return v;
    }
}
