package com.example.senior6_002.user.view.act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.senior6_002.MainActivity;
import com.example.senior6_002.R;
import com.jaeger.library.StatusBarUtil;

public class UserMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        StatusBarUtil.setTranslucent(UserMainActivity.this,0);

        //StatusBarUtil.setTranslucent( UserMainActivity.this , 127 ) ;
    }
}
