package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Logbook4Activity extends AppCompatActivity {

    private TextView tv_number, tv_date;
    private TextView tv_location, tv_locationtype, tv_point, tv_temperature, tv_entertime, tv_exittime, tv_resttime, tv_weight, tv_enterpressure, tv_exitpressure;
    private TextView tv_view, tv_wave, tv_maxdepth, tv_avedepth, tv_memo;
    private CheckBox cb_stop, cb_speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //onCreate 메소드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook4);

        tv_number = findViewById(R.id.tv_number);
        tv_date = findViewById(R.id.tv_date);
        tv_location= findViewById(R.id.tv_location);
        tv_locationtype = findViewById(R.id.tv_locationtype);
        tv_point = findViewById(R.id.tv_point);
        tv_temperature = findViewById(R.id.tv_temperature);
        tv_entertime= findViewById(R.id.tv_entertime);
        tv_exittime = findViewById(R.id.tv_exittime);
        tv_resttime= findViewById(R.id.tv_resttime);
        tv_weight = findViewById(R.id.tv_weight);
        tv_enterpressure = findViewById(R.id.tv_enterpressure);
        tv_exitpressure = findViewById(R.id.tv_exitpressure);
        tv_view = findViewById(R.id.tv_view);
        tv_wave = findViewById(R.id.tv_wave);
        tv_maxdepth = findViewById(R.id.tv_maxdepth);
        tv_avedepth= findViewById(R.id.tv_avedepth);
        cb_stop= findViewById(R.id.cb_stop);
        cb_speed= findViewById(R.id.cb_speed);
        tv_memo= findViewById(R.id.tv_memo);

        Intent intent = getIntent();
        int logNumber = intent.getIntExtra("logNumber", 9);
        String logDate = intent.getStringExtra("logDate");
        String logLocation = intent.getStringExtra("logLocation");
        String logLocationType = intent.getStringExtra("logLocationType");
        String logPoint = intent.getStringExtra("logPoint");
        int logTemperature = intent.getIntExtra("logTemperature", 9);
        String logEnterTime = intent.getStringExtra("logEnterTime");
        String logExitTime = intent.getStringExtra("logExitTime");
        String logRestTime = intent.getStringExtra("logRestTime");
        int logWeight = intent.getIntExtra("logWeight", 9);
        int logEnterPressure = intent.getIntExtra("logEnterPressure", 9);
        int logExitPressure = intent.getIntExtra("logExitPressure", 9);
        int logView = intent.getIntExtra("logView", 9);
        String logWave = intent.getStringExtra("logWave");
        int logMaxDepth = intent.getIntExtra("logMaxDepth", 9);
        int logAveDepth = intent.getIntExtra("logAveDepth", 9);
        int logStopFollow = intent.getIntExtra("logStopFollow", 9);
        int logSpeedFollow = intent.getIntExtra("logSpeedFollow", 9);
        String logMemo = intent.getStringExtra("logMemo");

        tv_number.setText(String.valueOf(logNumber));
        tv_date.setText(logDate);
        tv_location.setText(logLocation);
        tv_locationtype.setText(logLocationType);
        tv_point.setText(logPoint);
        tv_temperature.setText(String.valueOf(logTemperature));
        tv_entertime.setText(logEnterTime);
        tv_exittime.setText(logExitTime);
        tv_resttime.setText(logRestTime);
        tv_weight.setText(String.valueOf(logWeight));
        tv_enterpressure.setText(String.valueOf(logEnterPressure));
        tv_exitpressure.setText(String.valueOf(logExitPressure));
        tv_view.setText(String.valueOf(logView));
        tv_wave.setText(logWave);
        tv_maxdepth.setText(String.valueOf(logMaxDepth));
        tv_avedepth.setText(String.valueOf(logAveDepth));
        cb_stop.setText(String.valueOf(logStopFollow));     //검사
        cb_speed.setText(String.valueOf(logSpeedFollow));
        tv_memo.setText(logMemo);

    }
}
