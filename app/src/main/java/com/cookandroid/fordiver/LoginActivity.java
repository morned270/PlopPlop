package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //텍스트뷰 정의
        final TextView Text_ID = (TextView)findViewById(R.id.Text_ID);
        final TextView Text_PW = (TextView)findViewById(R.id.Text_PW);

        //액티비티 전환 Intent 정의
        final Intent intent_su = new Intent(this, SignupActivity.class);

        //버튼 정의
        Button btn_su = (Button)findViewById(R.id.Btn_Signup);
        Button btn_Li = (Button)findViewById(R.id.Btn_Login);

        //회원가입 버튼을 눌렀을 때
        btn_su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_su);
            }
        });

        //로그인 버튼을 눌렀을 때
        btn_Li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Text_ID.getText())) { //ID 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(ID누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(Text_PW.getText())) { //PW 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(PW누락)",Toast.LENGTH_LONG).show();
                }
                //아이디 패스워드 둘 다 적었을 때
                else{
                    // 아이디 패스워드 DB에서 찾는 기능 추가 필요함

                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_LONG).show();
                    //메인 화면으로 넘어가야 함

                }
            }
        });
    }
}
