package com.cookandroid.fordiver;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.content.Intent;

public class Logbook2Activity extends AppCompatActivity {

    Switch switchlogview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook2);

        final ListView listview;
        Logbook2ListViewAdapter adapter;

        // Adapter 생성
        adapter = new Logbook2ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#1", "날짜 : 2020.05.27", "말라파스쿠아");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#2", "날짜 : 2020.04.20", "세부");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#3", "날짜 : 2020.04.19", "세부");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#4", "날짜 : 2020.04.18", "세부");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#5", "날짜 : 2020.01.03", "제주도");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#6", "날짜 : 2020.01.02", "제주도");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.diverimg),
                "#7", "날짜 : 2020.01.02", "제주도");

        //위에서 생성한 Listview에서 클릭했을 때 이벤트 정의
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Logbook2ListViewItem item = (Logbook2ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String dateStr = item.getdate();
                String locationStr = item.getlocation();
                Drawable iconDrawable = item.getIcon();

                Intent intent_li = new Intent(Logbook2Activity.this, Logbook4Activity.class) ;
                startActivity(intent_li);
                //TODO : USE ITEM DATA. 클릭하면 진행할 이벤트
            }
        });

        switchlogview = (Switch) findViewById(R.id.switchlogview);

        switchlogview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    //Toast.makeText(Logbook2Activity.this, "스위치-ON", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(Logbook2Activity.this, "스위치-OFF", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Logbook2Activity.this, Logbook3Activity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        });

    }


}