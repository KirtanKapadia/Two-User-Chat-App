package com.example.android.meandyou;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class userListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstances) {

        super.onCreate(saveInstances);
        setContentView(R.layout.activity_user_list);

        setTitle("Friends");

    }
}
