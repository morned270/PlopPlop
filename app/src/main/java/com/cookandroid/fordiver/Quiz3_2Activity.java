package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz3_2Activity extends AppCompatActivity {
    int quiz_num=0;
    int correct_count=0;
    int wrong_count=0;
    int[] allresult=new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_2);

        final Intent intent2quiz4 = new Intent(Quiz3_2Activity.this, Quiz4Activity.class);

        TextView getcourse = (TextView)findViewById(R.id.aow_quiz_course); //퀴즈 난이도 쓸 textview 선언

        final TextView quiz_text = (TextView)findViewById(R.id.aow_quiz_text);    //문제와 문제의 답 버튼들 선언
        final Button btn_ans_1 = (Button)findViewById(R.id.btn_aow_ans_1);
        final Button btn_ans_2 = (Button)findViewById(R.id.btn_aow_ans_2);
        final Button btn_ans_3 = (Button)findViewById(R.id.btn_aow_ans_3);
        final Button btn_ans_4 = (Button)findViewById(R.id.btn_aow_ans_4);

        Intent intent2 = getIntent(); /*Quiz2 화면으로부터 데이터 전달받기위함*/
        String course = intent2.getExtras().getString("course"); /*선택한 퀴즈 단계 불러오기*/
        getcourse.setText(course);


        final String[] arr_text = getResources().getStringArray(R.array.aow_quiz_text); /*quiz_aow 불러오기*/
        final String[] arr_ans1 = getResources().getStringArray(R.array.aow_ans_1);
        final String[] arr_ans2 = getResources().getStringArray(R.array.aow_ans_2);
        final String[] arr_ans3 = getResources().getStringArray(R.array.aow_ans_3);
        final String[] arr_ans4 = getResources().getStringArray(R.array.aow_ans_4);
        final int[] arr_anslist = getResources().getIntArray(R.array.aow_anslist);


        quiz_text.setText(arr_text[0]); //첫번째 문제 띄우기
        btn_ans_1.setText(arr_ans1[0]);
        btn_ans_2.setText(arr_ans2[0]);
        btn_ans_3.setText(arr_ans3[0]);
        btn_ans_4.setText(arr_ans4[0]);

        btn_ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = arr_anslist[quiz_num]==1?1:2; //정답이면 1 틀리면 2를
                if(result==1)
                    correct_count++;
                else
                    wrong_count++;

                allresult[quiz_num]=result; // 결과리스트 allresult에 저장

                if(quiz_num<9) {
                    quiz_num++;// 다음문제로 넘어가기
                    quiz_text.setText(arr_text[quiz_num]); //다음 문제 띄우기
                    btn_ans_1.setText(arr_ans1[quiz_num]);
                    btn_ans_2.setText(arr_ans2[quiz_num]);
                    btn_ans_3.setText(arr_ans3[quiz_num]);
                    btn_ans_4.setText(arr_ans4[quiz_num]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "맞은 문제는 "+correct_count+"개, 틀린문제는 "+wrong_count, Toast.LENGTH_SHORT).show();
                    intent2quiz4.putExtra("correct",correct_count); /*송신*/
                    intent2quiz4.putExtra("wrong",wrong_count); /*송신*/
                    startActivity(intent2quiz4);
                    //결과 화면으로 넘어가기
                }
            }
        });

        btn_ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = arr_anslist[quiz_num]==2?1:2; //정답이면 1 틀리면 2를
                if(result==1)
                    correct_count++;
                else
                    wrong_count++;

                allresult[quiz_num]=result; // 결과리스트 allresult에 저장

                if(quiz_num<9) {
                    quiz_num++;// 다음문제로 넘어가기
                    quiz_text.setText(arr_text[quiz_num]); //다음 문제 띄우기
                    btn_ans_1.setText(arr_ans1[quiz_num]);
                    btn_ans_2.setText(arr_ans2[quiz_num]);
                    btn_ans_3.setText(arr_ans3[quiz_num]);
                    btn_ans_4.setText(arr_ans4[quiz_num]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "맞은 문제는 "+correct_count+"개, 틀린문제는 "+wrong_count, Toast.LENGTH_SHORT).show();
                    intent2quiz4.putExtra("correct",correct_count); /*송신*/
                    intent2quiz4.putExtra("wrong",wrong_count); /*송신*/
                    startActivity(intent2quiz4);
                    //결과 화면으로 넘어가기
                }
            }
        });

        btn_ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = arr_anslist[quiz_num]==3?1:2; //정답이면 1 틀리면 2를
                if(result==1)
                    correct_count++;
                else
                    wrong_count++;

                allresult[quiz_num]=result; // 결과리스트 allresult에 저장

                if(quiz_num<9) {
                    quiz_num++;// 다음문제로 넘어가기
                    quiz_text.setText(arr_text[quiz_num]); //다음 문제 띄우기
                    btn_ans_1.setText(arr_ans1[quiz_num]);
                    btn_ans_2.setText(arr_ans2[quiz_num]);
                    btn_ans_3.setText(arr_ans3[quiz_num]);
                    btn_ans_4.setText(arr_ans4[quiz_num]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "맞은 문제는 "+correct_count+"개, 틀린문제는 "+wrong_count, Toast.LENGTH_SHORT).show();
                    intent2quiz4.putExtra("correct",correct_count); /*송신*/
                    intent2quiz4.putExtra("wrong",wrong_count); /*송신*/
                    startActivity(intent2quiz4);
                    //결과 화면으로 넘어가기
                }
            }
        });

        btn_ans_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = arr_anslist[quiz_num]==4?1:2; //정답이면 1 틀리면 2를
                if(result==1)
                    correct_count++;
                else
                    wrong_count++;

                allresult[quiz_num]=result; // 결과리스트 allresult에 저장

                if(quiz_num<9) {
                    quiz_num++;// 다음문제로 넘어가기
                    quiz_text.setText(arr_text[quiz_num]); //다음 문제 띄우기
                    btn_ans_1.setText(arr_ans1[quiz_num]);
                    btn_ans_2.setText(arr_ans2[quiz_num]);
                    btn_ans_3.setText(arr_ans3[quiz_num]);
                    btn_ans_4.setText(arr_ans4[quiz_num]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "맞은 문제는 "+correct_count+"개, 틀린문제는 "+wrong_count, Toast.LENGTH_SHORT).show();
                    intent2quiz4.putExtra("correct",correct_count); /*송신*/
                    intent2quiz4.putExtra("wrong",wrong_count); /*송신*/
                    startActivity(intent2quiz4);
                    //결과 화면으로 넘어가기
                }
            }
        });
    }
}
