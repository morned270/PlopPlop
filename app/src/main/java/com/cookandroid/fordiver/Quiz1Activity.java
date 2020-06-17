package com.cookandroid.fordiver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Quiz1Activity extends Fragment {
    private View view;

    public Quiz1Activity() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_quiz1, container, false);
        Button btn_start_quiz = (Button) view.findViewById(R.id.btn_start_quiz);
        btn_start_quiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // fragment -> activity 액티비티 전환 Intent 정의
                Intent intent = new Intent(getActivity(), Quiz2Activity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
