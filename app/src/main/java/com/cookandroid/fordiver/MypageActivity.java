package com.cookandroid.fordiver;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MypageActivity extends Fragment {

    private View view;
    private TextView tv_name, tv_course;

    public MypageActivity() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mypage, container, false);

        tv_name = view.findViewById(R.id.tv_name);
        tv_course = view.findViewById(R.id.tv_course);

        Intent intent = getActivity().getIntent();
        String userID = intent.getStringExtra("userID");
        String userName = intent.getStringExtra("userName");
        String userCourse = intent.getStringExtra("userCourse");

        tv_name.setText(userName);
        tv_course.setText(userCourse);

        File imgFile = new File("/sdcard/Android/data/com.cookandroid.fordiver/files/Pictures/" + userID + ".jpg");

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView)view.findViewById(R.id.iv_profile);

            myImage.setImageBitmap(myBitmap);

        }

        return view;
    }
}
