package com.cookandroid.fordiver;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Logbook5Activity extends AppCompatActivity {

    /* 카메라 관련 변수들 */
    private static final int REQUEST_IMAGE_CAPTURE = 672;
    private String imageFilePath;
    private Uri photoUri;
    public int i = 1;
    private Button btn_capture;

    //tv_id
    private TextView tv_number, tv_date;
    private EditText et_location, et_temperature, et_entertime, et_exittime, et_resttime, et_weight, et_enterpressure, et_exitpressure;
    private EditText et_view, et_wave, et_maxdepth, et_avedepth, et_memo;
    private CheckBox cb_stop, cb_speed;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook5);

        //권한 체크해주는 팝업
        TedPermission.with(getApplicationContext())
                .setPermissionListener(permissionListener)
                .setRationaleMessage("카메라 권한이 필요합니다.")
                .setDeniedMessage("거부하셨습니다.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();

        //촬영 버튼을 눌렀을 경우

        btn_capture = findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(new View.OnClickListener() {
        /* findViewById(R.id.btn_capture).setOnClickListener(new View.OnClickListener() { */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);    //카메라 실행 구문
                if(intent.resolveActivity(getPackageManager())!=null){
                    File photoFile = null;
                    try{
                        photoFile = createImageFile();
                        i++;
                    } catch(IOException e){

                    }

                    if(photoFile != null){
                        photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                        //윗 줄은 다음 intent로 화면 전환이 일어난 후, 다시 이 액티비티로 돌아올 때 값을 가지고 오는 역할
                    }
                }
            }
        });

        // 아이디 값 찾아주기
        //tv_id = findViewById(R.id.tv_id);
        tv_number = (TextView)findViewById(R.id.tv_number);
        tv_date = findViewById(R.id.tv_date);
        et_location = findViewById(R.id.et_location);
        et_temperature = findViewById(R.id.et_temperature);
        et_entertime = findViewById(R.id.et_entertime);
        et_exittime = findViewById(R.id.et_exittime);
        et_resttime = findViewById(R.id.et_resttime);
        et_weight = findViewById(R.id.et_weight);
        et_enterpressure = findViewById(R.id.et_enterpressure);
        et_exitpressure = findViewById(R.id.et_exitpressure);
        et_view = findViewById(R.id.et_view);
        et_wave = findViewById(R.id.et_wave);
        et_maxdepth = findViewById(R.id.et_maxdepth);
        et_avedepth = findViewById(R.id.et_avedepth);
        cb_stop = findViewById(R.id.cb_stop);
        cb_speed = findViewById(R.id.cb_speed);
        et_memo = findViewById(R.id.et_memo);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        int userLog = intent.getIntExtra("userLog", 9);
        tv_number.setText(String.valueOf(userLog + 1));

        //오늘 날짜 출력
        Calendar mCalendar = Calendar.getInstance();
        Date today = mCalendar.getTime();
        String todayInStr = new SimpleDateFormat("yyyy-MM-dd").format(today);
        tv_date.setText(todayInStr);

        //spinner 리스트에 추가하기
        final String[] data =getResources().getStringArray(R.array.diveloca);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        final Spinner spinner = (Spinner)findViewById(R.id.sp_locationtype);
        spinner.setAdapter(adapter);

        final String[] data2 =getResources().getStringArray(R.array.divept);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data2);
        final Spinner spinner2 = (Spinner)findViewById(R.id.sp_point);
        spinner2.setAdapter(adapter2);


        //등록 버튼 클릭시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                //String logUser = tv_id.getText().toString();
                String logUser = userID;
                int logNumber = Integer.parseInt(tv_number.getText().toString());
                String logDate = tv_date.getText().toString();
                String logLocation = et_location.getText().toString();
                String logLocationType = spinner.getSelectedItem().toString();
                String logPoint = spinner2.getSelectedItem().toString();
                int logTemperature = Integer.parseInt(et_temperature.getText().toString());
                String logEnterTime  = et_entertime.getText().toString();
                String logExitTime = et_exittime.getText().toString();
                String logRestTime = et_resttime.getText().toString();
                int logWeight = Integer.parseInt(et_weight.getText().toString());
                int logEnterPressure = Integer.parseInt(et_enterpressure.getText().toString());
                int logExitPressure = Integer.parseInt(et_exitpressure.getText().toString());
                int logView = Integer.parseInt(et_view.getText().toString());
                String logWave = et_wave.getText().toString();
                int logMaxDepth = Integer.parseInt(et_maxdepth.getText().toString());
                int logAveDepth = Integer.parseInt(et_avedepth.getText().toString());
                int logStopFollow = 0;
                int logSpeedFollow = 0;
                if (cb_stop.isChecked() == true ) {
                    logStopFollow = 1;
                }
                if (cb_speed.isChecked() == true ) {
                    logSpeedFollow = 1;
                }
                String logMemo = et_memo.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){    // 로그북 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "로그북 등록에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Logbook5Activity.this, Logbook4Activity.class); //수정하기
                                startActivity(intent);
                            }
                            else{   // 로그북 등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그북 등록에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청을 함.
                LogbookRequest LogbookRequest = new LogbookRequest(logUser, logNumber, logDate, logLocation, logLocationType, logPoint,
                        logTemperature, logEnterTime, logExitTime, logRestTime, logWeight,
                        logEnterPressure, logExitPressure, logView, logWave, logMaxDepth, logAveDepth,
                        logStopFollow, logSpeedFollow, logMemo, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Logbook5Activity.this);
                queue.add(LogbookRequest);

            }
        });

    }

    private File createImageFile() throws IOException {
        String imageFileName = "Picture" + String.valueOf(i) + ".jpg";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = new File(storageDir, imageFileName);
        imageFilePath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
            ExifInterface exif = null;

            try{
                exif = new ExifInterface(imageFilePath);
            } catch(IOException e){
                e.printStackTrace();
            }

            int exifOrientation;
            int exifDegree;

            if(exif != null){
                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                exifDegree = exifOrientationToDegrees(exifOrientation);
            } else{
                exifDegree = 0;
            }

            ((ImageView) findViewById(R.id.iv_result)).setImageBitmap(rotate(bitmap,exifDegree));
        }
    }

    //촬영 시 화면이 돌아갔을 경우
    private int exifOrientationToDegrees(int exifOrientation){
        if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90){
            return 90;
        } else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_180){
            return 180;
        } else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_270){
            return 270;
        }
        return 0;
    }

    private Bitmap rotate(Bitmap bitmap, float degree){
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(getApplicationContext(), "권한이 허용됨", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(getApplicationContext(), "권한이 거부됨", Toast.LENGTH_SHORT).show();
        }
    };

}
