package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //spinner 리스트에 추가하기
        final String[] data =getResources().getStringArray(R.array.course);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        Spinner spinner = (Spinner)findViewById(R.id.Spn_SU_C);
        spinner.setAdapter(adapter);

        final TextView Text_id = (TextView)findViewById(R.id.Text_SU_ID);
        final TextView Text_pw = (TextView)findViewById(R.id.Text_SU_PW);
        final TextView Text_NAME = (TextView)findViewById(R.id.Text_SU_NAME);

        Button btn_ok = (Button)findViewById(R.id.Btn_SU_OK);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Text_id.getText())) { //ID 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(ID누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(Text_pw.getText())) { //PW 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(패스워드누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(Text_NAME.getText())) { //닉네임 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(닉네임 누락)",Toast.LENGTH_LONG).show();
                }
                else{
                    //디비연동해서 해당 계정있는지 확인하는 과정 필요

                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_LONG).show();
                    //로그인액티비티로 돌아가야 함

                }
            }
        });
        //
    }
}
