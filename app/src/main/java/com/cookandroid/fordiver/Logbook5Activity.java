package com.cookandroid.fordiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Logbook5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook5);

        //spinner 리스트에 추가하기
        final String[] data =getResources().getStringArray(R.array.diveloca);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        final Spinner spinner = (Spinner)findViewById(R.id.LB_SP_1);
        spinner.setAdapter(adapter);

        final String[] data2 =getResources().getStringArray(R.array.divept);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data2);
        final Spinner spinner2 = (Spinner)findViewById(R.id.LB_SP_2);
        spinner2.setAdapter(adapter2);
    }
}
