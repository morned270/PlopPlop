package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Logbook3Activity extends AppCompatActivity {

    Switch switchlogview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook3);

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
}
