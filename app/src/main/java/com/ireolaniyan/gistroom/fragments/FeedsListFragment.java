package com.ireolaniyan.gistroom.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ireolaniyan.gistroom.model.Feed;
import com.ireolaniyan.gistroom.R;
import com.ireolaniyan.gistroom.activities.SingleFragmentActivity;
import com.ireolaniyan.gistroom.activities.FeedsActivity;

import java.util.ArrayList;

/**
 * Created by Ire Olaniyan on 11/6/2016.
 */
public class FeedsListFragment extends Fragment {
//    private Feed mFeed;
    private RecyclerView mFeedsRecyclerView;
    private RecyclerView.Adapter mFeedAdapter;
    final ArrayList<String> feeds = new ArrayList<>();
    private String feed;
    private int mExpandedPosition = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
//        mFeed = new Feed();
    }

//        Creating a recycler view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_feeds_list, container, false);

        SingleFragmentActivity activity = (SingleFragmentActivity)getActivity();
        activity.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vw = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_compose, null);

                final EditText mComposeGist = (EditText) vw.findViewById(R.id.dialog_compose_gist);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setView(vw)   /*configures the dialog to display the passed-in View object between the dialog’s title and its button*/
                        .setTitle(R.string.compose_gist_title)
                        .setPositiveButton(android.R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        feed = new String(mComposeGist.getText().toString());
                                        feeds.add(0, feed);
                                    }
                                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        mFeedsRecyclerView = (RecyclerView) view.findViewById(R.id.feeds_recycler_view);
        mFeedsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        mFeedAdapter = new FeedsAdapter(feeds);
        mFeedsRecyclerView.setAdapter(mFeedAdapter);
//        mFeedAdapter.notifyItemInserted(0);
        mFeedAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//         Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.feed, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    Setting a different fab action for this fragment.
//    Prevent getActivity() from returning null while extending fab.
    @Override
    public void setUserVisibleHint(boolean visible) {
        super.setUserVisibleHint(visible);
        if (visible && isResumed()) {
            onResume();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!getUserVisibleHint()) {
//            return;
            Toast.makeText(getActivity(), "An error occurred.", Toast.LENGTH_SHORT).show();
        }
    }

//            Defining the ViewHolder.
    private class FeedsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mFeedsTextView;
        private ImageView mImageView;
        private Feed mFeed;

        public FeedsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mFeedsTextView = (TextView) itemView.findViewById(R.id.list_feeds_textView);

            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.simple_image);
            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), bm);
            drawable.setCircular(true);
            mImageView = (ImageView) itemView.findViewById(R.id.simple_imageView);
            mImageView.setImageDrawable(drawable);
        }

        @Override
        public void onClick(View v) {
            Intent intent = FeedsActivity.newIntent(getActivity(), mFeed.getId());
            startActivity(intent);
//            Toast.makeText(getActivity(), mFeed.getFeed() + " clicked", Toast.LENGTH_SHORT).show();
//            viewFeed(feed);
        }
    
      /*  private void viewFeed(String feed){
            Intent intent = FeedsActivity.newIntent(getActivity(), mFeed.getId());
            intent.putExtra("feed", feed);
            startActivity(intent);
        }*/
    }

    private class FeedsAdapter extends RecyclerView.Adapter<FeedsHolder>{
        ArrayList<String> mFeeds;
        public FeedsAdapter(ArrayList<String> feeds){
            mFeeds = feeds;
        }

//                Called by the RecyclerView when it needs a new View to display an item.
        @Override
        public FeedsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View view = layoutInflater.inflate(R.layout.list_item_feeds, parent, false);
            return new FeedsHolder(view);
        }

//                Bind a ViewHolder’s View to your feed object.
        @Override
        public void onBindViewHolder(FeedsHolder holder, final int position) {
            holder.mFeedsTextView.setText(mFeeds.get(position));

//            TODO: Add expand/collapse view to RecyclerView.
            /*final boolean isExpanded = position == mExpandedPosition;
            holder.mFeedsTextView.setVisibility(isExpanded?View.VISIBLE:View.GONE);
            holder.itemView.setActivated(isExpanded);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExpandedPosition = isExpanded ? -1 : position;
                    TransitionManager.beginDelayedTransition(mFeedsRecyclerView);
                }
            });*/
        }

        @Override
        public int getItemCount() {
            return mFeeds.size();
        }
    }
}
