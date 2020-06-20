package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        TextView correct_count = (TextView)findViewById(R.id.text_correct_count); //맞은 개수를 쓸 textview 선언
        TextView wrong_count = (TextView)findViewById(R.id.text_wrong_count);
        Button finishbtn = (Button)findViewById(R.id.btn_quiz_end);

        Intent intent = getIntent(); /*Quiz2 화면으로부터 데이터 전달받기위함*/
        int correct = intent.getExtras().getInt("correct"); /*선택한 퀴즈 단계 불러오기*/
        correct_count.setText("맞은 개수 : "+correct+"/10개");
        int wrong = 10-correct; /*선택한 퀴즈 단계 불러오기*/
        wrong_count.setText("틀린 개수 : "+wrong+"/10개");


        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
