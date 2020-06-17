package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        Button btn_ow = (Button)findViewById(R.id.btn_q_ow);
        Button btn_aow = (Button)findViewById(R.id.btn_q_aow);

        btn_ow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값 넘겨주기
                //액티비티 전환 Intent 정의
                Intent intent = new Intent(Quiz2Activity.this, Quiz3Activity.class);
                intent.putExtra("course","OpenWater"); /*송신*/

                startActivity(intent);
            }
        });

        btn_aow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //값 넘겨주기
                //액티비티 전환 Intent 정의
                Intent intent2 = new Intent(Quiz2Activity.this, Quiz3_2Activity.class);
                intent2.putExtra("course","Advanced OpenWater");

                startActivity(intent2);

            }
        });
    }
}
