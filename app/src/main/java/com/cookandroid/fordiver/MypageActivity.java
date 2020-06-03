package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MypageActivity extends AppCompatActivity {

    private TextView tv_name, tv_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        tv_name = findViewById(R.id.tv_name);
        tv_course = findViewById(R.id.tv_course);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userCourse = intent.getStringExtra("userCourse");

        tv_name.setText(userName);
        tv_course.setText(userCourse);

    }
}
