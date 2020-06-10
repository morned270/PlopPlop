package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Fragment{
    private View view;

    public MainActivity() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main, container, false);

        //버튼 정의
        Button btn_addLB = view.findViewById(R.id.btn_addLB);
        Button btn_ShowLB = view.findViewById(R.id.btn_ShowLB);

        //추가하기 버튼을 눌렀을 때
        btn_addLB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티 전환 Intent 정의
                Intent intent = new Intent(getActivity(), Logbook5Activity.class);
                startActivity(intent);
            }
        });

        //열람하기 버튼을 눌렀을 때5
        btn_ShowLB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티 전환 Intent 정의
                Intent intent = new Intent(getActivity(), Logbook2Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
