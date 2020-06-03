package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MypageActivity extends AppCompatActivity {

    private TextView tv_course, tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        tv_course = findViewById(R.id.tv_course);
        tv_pass = findViewById(R.id.tv_pass);

        Intent intent = getIntent();
        String userCourse = intent.getStringExtra("userCourse");
        String userPass = intent.getStringExtra("userPass");

        tv_course.setText(userCourse);
        tv_pass.setText(userPass);

    }
}
