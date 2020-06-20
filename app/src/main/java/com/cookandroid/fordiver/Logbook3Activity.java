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
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.GeometryUtils;

import java.io.IOException;
import java.util.List;

public class Logbook3Activity extends FragmentActivity implements OnMapReadyCallback {

    String et_location = "보홀"; //db에서 값을 받으면

    String location[] = {"필리핀", "보홀", "말라파스쿠아"}; //주소
    double latitude[]  = {10.277600, 9.911736, 11.336457}; //경도
    double longitude[] =  {123.972569, 124.217833, 10.415150}; //위도

    Switch switchlogview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook3);
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
                    //Toast.makeText(Logbook3Activity.this, "스위치-ON", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Logbook3Activity.this, Logbook2Activity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                } else {
                    //Toast.makeText(Logbook3Activity.this, "스위치-OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // ...

        Marker marker[] = new Marker[location.length];
        for(int i=0; i<location.length; i++){
            marker[i] = new Marker();
            if(et_location == location[i]){
                marker[i].setPosition(new LatLng(latitude[i], longitude[i]));
                marker[i].setCaptionText(location[i]);
                marker[i].setMap(naverMap);
            }
        }

    }
}
