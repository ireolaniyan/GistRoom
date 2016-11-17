package com.ireolaniyan.gistroom;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Ire Olaniyan on 11/14/2016.
 */
public class ComposeGistFragment extends DialogFragment {

    private Feed mFeed;
    private static final String ARG_FEED = "feed";
    private EditText mComposeField;

    /* To get data into ComposeGistFragment, stash the feed in ComposeGistFragment’s
    arguments bundle, where the ComposeGistFragment can access it. This is typically done in a
    newInstance() method that replaces the fragment constructor */
    public static ComposeGistFragment newInstance(String feed){
        Bundle args = new Bundle();
        args.putSerializable(ARG_FEED, feed);

        ComposeGistFragment fragment = new ComposeGistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
//        Inflating the view:
// dialog_compose.xml
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_compose, null);

        mComposeField = (EditText) v.findViewById(R.id.dialog_compose_gist);

        mComposeField.setText(mFeed.getFeed());

//        Text input
        mComposeField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFeed.setFeed(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(v)   /*configures the dialog to display the passed-in View object between the dialog’s title and its button*/
                .setTitle(R.string.compose_gist_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
