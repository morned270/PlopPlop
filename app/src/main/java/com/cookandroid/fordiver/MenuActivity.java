package com.cookandroid.fordiver;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MainActivity frag1;
    private Quiz1Activity frag2;
    private MypageActivity frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_1:
                        setFrag(0);
                        break;
                    case R.id.action_2:
                        setFrag(1);
                        break;
                    case R.id.action_3:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        frag1 = new MainActivity();
        frag2 = new Quiz1Activity();
        frag3 = new MypageActivity();
        setFrag(0); //첫 프래그먼으 화면을 무엇으로 지정해줄 것인지 선택
    }

    //프래그먼트 교테가 일어나는 실행문이다.
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();    //저장
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();    //저장
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();    //저장
                break;
        }
    }
}
