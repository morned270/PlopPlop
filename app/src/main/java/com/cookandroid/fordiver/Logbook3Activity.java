package com.cookandroid.fordiver;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.GeometryUtils;

import java.io.IOException;
import java.util.List;

public class Logbook3Activity extends FragmentActivity implements OnMapReadyCallback {

    String[] location;
    String[] latitude;
    String[] longitude;
    Switch switchlogview;
    TextView tv_log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook3);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final int userLog = intent.getIntExtra("userLog", 9);

        tv_log = findViewById(R.id.tv_log);
        tv_log.setText(String.valueOf(userLog) + "회");


        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);

        switchlogview = (Switch) findViewById(R.id.switchlogview);

        switchlogview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){

                } else {
                    Intent intent = new Intent(Logbook3Activity.this, Logbook2Activity.class);
                    intent.putExtra("userID", userID);
                    intent.putExtra("userLog", userLog);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();
                }
            }
        });

    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // ...


        String[] logLocation = {"필리핀 보홀", "한국 제주도 송악산","말레이시아 시파단섬", "이집트 홍해", "한국 울릉도"};
        location = getResources().getStringArray(R.array.loca_name);
        latitude = getResources().getStringArray(R.array.loca_Latitude);     //위도
        longitude = getResources().getStringArray(R.array.loca_Longitude);   //경도

        Marker marker[] = new Marker[location.length];

        for(int i=0; i<location.length; i++){
            marker[i] = new Marker();
            if(logLocation[0].equals(location[i])){
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }
            if(logLocation[1].equals(location[i])){
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }
            if(logLocation[2].equals(location[i])){
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }
            if(logLocation[3].equals(location[i])){
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }
            if(logLocation[4].equals(location[i])){
                marker[i].setPosition(new LatLng(Double.parseDouble(latitude[i]), Double.parseDouble(longitude[i])));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }

        }

    }
}
