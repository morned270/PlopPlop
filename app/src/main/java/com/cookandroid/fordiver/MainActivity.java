package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //로그인 액티비티로 이동
        Intent intent_li = new Intent(MainActivity.this, LoginActivity.class) ;
        startActivity(intent_li);


    }


}
