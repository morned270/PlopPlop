package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //spinner 리스트에 추가하기
        final String[] data =getResources().getStringArray(R.array.course);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        final Spinner spinner = (Spinner)findViewById(R.id.sp_course);
        spinner.setAdapter(adapter);


        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);

        // 회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                String userCourse = spinner.getSelectedItem().toString();
                String userSpeciality = "해당 없음";
                int userLog = 0;
                int userGoal = 0;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){    // 회원 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else{   // 회원 등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        /*if (TextUtils.isEmpty(et_id.getText())) { //ID 칸이 비어있으면
                       //Toast 메세지 출력
                        Toast.makeText(getApplicationContext(),"실패(ID누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(et_pass.getText())) { //PW 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(패스워드누락)",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(et_name.getText())) { //닉네임 칸이 비어있으면
                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"실패(닉네임 누락)",Toast.LENGTH_LONG).show();
                }
                else{
                    //디비연동해서 해당 계정있는지 확인하는 과정 필요

                    //Toast 메세지 출력
                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_LONG).show();
                    //로그인액티비티로 돌아가야 함

                }*/

                    }
                };

                //서버로 Volley를 이용해서 요청을 함.
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userCourse, userSpeciality, userLog, userGoal, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                queue.add(registerRequest);
            }
        });

    }
}