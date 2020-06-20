package com.cookandroid.fordiver;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class Logbook4Activity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView tv_number, tv_date;
    private TextView tv_location, tv_locationtype, tv_point, tv_temperature, tv_entertime, tv_exittime, tv_resttime, tv_weight, tv_enterpressure, tv_exitpressure;
    private TextView tv_view, tv_wave, tv_maxdepth, tv_avedepth, tv_memo;
    private CheckBox cb_stop, cb_speed;

    String[] location;
    String[] latitude;
    String[] longitude;

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
        String logUser = intent.getStringExtra("logUser");
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
        if (logStopFollow == 1) {
            cb_stop.setChecked(true);
        }
        if (logSpeedFollow == 1) {
            cb_speed.setChecked(true);
        }
        tv_memo.setText(logMemo);

        File imgFile = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + logUser + "_log" + String.valueOf(logNumber) + ".jpg");

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView)findViewById(R.id.iv_result);

            myImage.setImageBitmap(myBitmap);

        }

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);


    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // ...
        String logLocation = tv_location.getText().toString();
        location = getResources().getStringArray(R.array.loca_name);
        latitude = getResources().getStringArray(R.array.loca_Latitude);     //위도
        longitude = getResources().getStringArray(R.array.loca_Longitude);   //경도


        Marker marker[] = new Marker[location.length];
        for(int i=0; i<location.length; i++){
            marker[i] = new Marker();
            if(logLocation.equals(location[i])){
                naverMap.setCameraPosition(new CameraPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])), 3));
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }

        }
    }

}
