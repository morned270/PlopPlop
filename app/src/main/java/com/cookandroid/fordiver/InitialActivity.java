package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_initial);

        //로그인 액티비티로 이동
        Intent intent_li = new Intent(InitialActivity.this, LoginActivity.class) ;
        startActivity(intent_li);
    }
}
