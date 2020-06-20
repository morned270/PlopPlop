package com.cookandroid.fordiver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;


public class Logbook2Activity extends AppCompatActivity {

    ListView listview;
    Logbook2ListViewAdapter adapter;
    Switch switchlogview;
    TextView tv_log;

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook2);

        //final ListView listview;
        //final Logbook2ListViewAdapter adapter;

        // Adapter 생성
        adapter = new Logbook2ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        //Main.java 에서 데이터 받아오기
        Intent intent = getIntent();
        final String logUser = intent.getStringExtra("userID");
        final int logNumber = intent.getIntExtra("userLog", 9);

        tv_log = findViewById(R.id.tv_log);
        tv_log.setText(String.valueOf(logNumber) + "회");


//        for( int i = 1; i <= logNumber; i++) {
//
//            Log.d("myTag", "3");
//
//            /*셀렉트 쿼리 코드 시작*/
//            Response.Listener<String> responseListener = new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        boolean success = jsonObject.getBoolean("success");
//                        if(success){    // 셀렉트쿼리에 성공한 경우
//
//
//                            int logNumber = jsonObject.getInt("logNumber");
//                            String logDate = jsonObject.getString("logDate");
//                            String logLocation = jsonObject.getString("logLocation");
//
//                             //i번째 아이템 추가.
//                            adapter.addItem(ContextCompat.getDrawable(Logbook2Activity.this, R.drawable.diverimg),
//                            ""+logNumber, ""+logDate, ""+logLocation);
//
//
//                        }
//                        else{   // 셀렉트쿼리에 실패한 경우
//                            Log.d("myTag", "6");
//                            Toast.makeText(getApplicationContext(), "셀렉트에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//            };
//
//            LogReadRequest logReadRequest = new LogReadRequest(logUser, i, responseListener);
//            RequestQueue queue = Volley.newRequestQueue(Logbook2Activity.this);
//            queue.add(logReadRequest);
//            /*셀렉트 쿼리 코드 끝*/
//
//        }


        File imgFile1 = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + "plopplop" + "_log1.jpg");
        File imgFile2 = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + "plopplop" + "_log2.jpg");
        File imgFile3 = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + "plopplop" + "_log3.jpg");
        File imgFile4 = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + "plopplop" + "_log4.jpg");
        File imgFile5 = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + "plopplop" + "_log5.jpg");

        if(imgFile1.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
            Drawable drawable = new BitmapDrawable(getResources(), myBitmap);
            adapter.addItem(drawable, "1", "2019-05-24", "필리핀 보홀");
        }
        if(imgFile2.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
            Drawable drawable = new BitmapDrawable(getResources(), myBitmap);
            adapter.addItem(drawable, "2", "2019-07-27", "한국 제주도 송악산");
        }
        if(imgFile3.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile3.getAbsolutePath());
            Drawable drawable = new BitmapDrawable(getResources(), myBitmap);
            adapter.addItem(drawable, "3", "2020-05-15", "말레이시아 파단섬");
        }
        if(imgFile4.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile4.getAbsolutePath());
            Drawable drawable = new BitmapDrawable(getResources(), myBitmap);
            adapter.addItem(drawable, "4", "2020-06-07", "이집트 홍해");
        }
        if(imgFile5.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile5.getAbsolutePath());
            Drawable drawable = new BitmapDrawable(getResources(), myBitmap);
            adapter.addItem(drawable, "5", "2020-06-14", "한국 울릉도");
        }




        //위에서 생성한 Listview에서 클릭했을 때 이벤트 정의
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Logbook2ListViewItem item = (Logbook2ListViewItem) parent.getItemAtPosition(position);

                int titleToInt = Integer.parseInt(item.getTitle());
                String dateStr = item.getdate();
                String locationStr = item.getlocation();
                Drawable iconDrawable = item.getIcon();

                /*셀렉트 쿼리 코드 시작*/
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){    // 셀렉트쿼리에 성공한 경우

                                //전해주고싶은 데이터
                                String logUser = jsonObject.getString("logUser");
                                int logNumber = jsonObject.getInt("logNumber");
                                String logDate = jsonObject.getString("logDate");
                                String logLocation = jsonObject.getString("logLocation");
                                String logLocationType = jsonObject.getString("logLocationType");
                                String logPoint = jsonObject.getString("logPoint");
                                int logTemperature = jsonObject.getInt("logTemperature");
                                String logEnterTime = jsonObject.getString("logEnterTime");
                                String logExitTime = jsonObject.getString("logExitTime");
                                String logRestTime = jsonObject.getString("logRestTime");
                                int logWeight = jsonObject.getInt("logWeight");
                                int logEnterPressure = jsonObject.getInt("logEnterPressure");
                                int logExitPressure = jsonObject.getInt("logExitPressure");
                                int logView = jsonObject.getInt("logView");
                                String logWave = jsonObject.getString("logWave");
                                int logMaxDepth = jsonObject.getInt("logMaxDepth");
                                int logAveDepth = jsonObject.getInt("logAveDepth");
                                int logStopFollow = jsonObject.getInt("logStopFollow");
                                int logSpeedFollow = jsonObject.getInt("logSpeedFollow");
                                String logMemo = jsonObject.getString("logMemo");

                                //Toast.makeText(getApplicationContext(), "셀렉트에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Logbook2Activity.this, Logbook4Activity.class);
                                intent.putExtra("logUser", logUser);
                                intent.putExtra("logNumber", logNumber);
                                intent.putExtra("logDate", logDate);
                                intent.putExtra("logLocation", logLocation);
                                intent.putExtra("logLocationType", logLocationType);
                                intent.putExtra("logPoint", logPoint);
                                intent.putExtra("logTemperature", logTemperature);
                                intent.putExtra("logEnterTime", logEnterTime);
                                intent.putExtra("logExitTime", logExitTime);
                                intent.putExtra("logRestTime", logRestTime);
                                intent.putExtra("logWeight", logWeight);
                                intent.putExtra("logEnterPressure", logEnterPressure);
                                intent.putExtra("logExitPressure", logExitPressure);
                                intent.putExtra("logView", logView);
                                intent.putExtra("logWave", logWave);
                                intent.putExtra("logMaxDepth", logMaxDepth);
                                intent.putExtra("logAveDepth", logAveDepth);
                                intent.putExtra("logStopFollow", logStopFollow);
                                intent.putExtra("logSpeedFollow", logSpeedFollow);
                                intent.putExtra("logMemo", logMemo);
                                startActivity(intent);
                            }
                            else{   // 셀렉트쿼리에 실패한 경우
                                Toast.makeText(getApplicationContext(), "셀렉트에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LogReadRequest logReadRequest = new LogReadRequest(logUser, titleToInt, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Logbook2Activity.this);
                queue.add(logReadRequest);
                /*셀렉트 쿼리 코드 끝*/

                //Intent intent_li = new Intent(Logbook2Activity.this, Logbook4Activity.class) ;
                //startActivity(intent_li);
                //TODO : USE ITEM DATA. 클릭하면 진행할 이벤트
            }
        });

        switchlogview = (Switch) findViewById(R.id.switchlogview);

        switchlogview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    //Toast.makeText(Logbook2Activity.this, "스위치-ON", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(Logbook2Activity.this, "스위치-OFF", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Logbook2Activity.this, Logbook3Activity.class);
                    intent.putExtra("userID", logUser);
                    intent.putExtra("userLog", logNumber);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

    }




}