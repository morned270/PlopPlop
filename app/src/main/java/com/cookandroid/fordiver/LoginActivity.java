package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //텍스트뷰 정의
        final TextView et_id = (TextView)findViewById(R.id.et_id);
        final TextView et_pass = (TextView)findViewById(R.id.et_pass);

        //버튼 정의
        Button btn_register = (Button)findViewById(R.id.btn_register);
        Button btn_login = (Button)findViewById(R.id.btn_login);

        //회원가입 버튼을 눌렀을 때
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티 전환 Intent 정의
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        //로그인 버튼을 눌렀을 때
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){    // 로그인에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MypageActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPass", userPass);
                                startActivity(intent);
                            }
                            else{   // 로그인에 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


                /*// 빈 칸이 존재할 경우 처리(수정 필요)
                if (TextUtils.isEmpty(et_id.getText())) { //ID 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(ID누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(et_pass.getText())) { //PW 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(PW누락)",Toast.LENGTH_LONG).show();
                }
                //아이디 패스워드 둘 다 적었을 때
                else{
                    // 아이디 패스워드 DB에서 찾는 기능 추가 필요함

                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_LONG).show();
                    //메인 화면으로 넘어가야 함

                }*/





            }
        });
    }
}
