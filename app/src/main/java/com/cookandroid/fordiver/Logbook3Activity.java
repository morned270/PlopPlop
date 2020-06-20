package com.cookandroid.fordiver;

import android.content.Intent;
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

public class Logbook3Activity extends FragmentActivity implements OnMapReadyCallback {

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
                    finish();
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
        Marker marker = new Marker();
        marker.setPosition(new LatLng(35.1798159, 129.0750222));
        marker.setMap(naverMap);

        Marker marker2 = new Marker();
        marker2.setPosition(new LatLng(35.151324, 128.923114));
        marker2.setMap(naverMap);

        InfoWindow infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return "Best Diving Point!";
            }
        });
        infoWindow.open(marker);
        infoWindow.open(marker2);
    }

}
