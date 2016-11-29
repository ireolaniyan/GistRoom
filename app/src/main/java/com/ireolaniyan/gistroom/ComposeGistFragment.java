package com.ireolaniyan.gistroom;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ire Olaniyan on 11/14/2016.
 */
public class ComposeGistFragment extends DialogFragment {

    public static final String EXTRA_FEED = "com.ireolaniyan.gistroom.feed";

    private EditText mComposeGist;
    private Feed mFeed;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
//        Inflating the view:
// dialog_compose.xml
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_compose, null);

        mComposeGist = (EditText) v.findViewById(R.id.dialog_compose_gist);

        return new AlertDialog.Builder(getActivity())
                .setView(v)   /*configures the dialog to display the passed-in View object between the dialog’s title and its button*/
                .setTitle(R.string.compose_gist_title)
                .setPositiveButton(android.R.string.ok,
                         new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String feed = mComposeGist.getText().toString();
                                Toast.makeText(getActivity(), feed, Toast.LENGTH_SHORT).show();
//                                sendResult(Activity.RESULT_OK, feed);
                            }
                        })
                .create();

    }

    private void sendResult(int resultCode, String feed){
        if(getTargetFragment() == null){
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_FEED, feed);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    @Override
    public void onPause(){
        super.onPause();

//        FeedsLab.get(getActivity()).updateFeed(mFeed);
    }
}
