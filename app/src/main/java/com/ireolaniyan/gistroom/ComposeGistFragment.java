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
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
//        Inflating the view:
// dialog_compose.xml
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_compose, null);

        return new AlertDialog.Builder(getActivity())
                .setView(v)   /*configures the dialog to display the passed-in View object between the dialog’s title and its button*/
                .setTitle(R.string.compose_gist_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    @Override
    public void onPause(){
        super.onPause();

        FeedsLab.get(getActivity())
                .updateFeed(mFeed);
    }
}
