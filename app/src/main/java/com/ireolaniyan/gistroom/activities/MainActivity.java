package com.ireolaniyan.gistroom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ireolaniyan.gistroom.R;
import com.ireolaniyan.gistroom.signup.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = (Button) findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), SignUpActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
