package com.ireolaniyan.gistroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ire Olaniyan on 9/9/2016.
 */
public class SignInActivity extends MainActivity {
    private Button mFacebookButton;
    private Button mTwitterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);

        mFacebookButton = (Button) findViewById(R.id.facebook_button);
        mTwitterButton = (Button) findViewById(R.id.twitter_button);

        mFacebookButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(v.getContext(), FeedsListActivity.class);
                startActivity(newIntent);
            }
        });
        mTwitterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(v.getContext(), FeedsListActivity.class);
                startActivity(newIntent);
            }
        });
    }
}
