package com.cookandroid.fordiver;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LogbookRequest extends StringRequest {

    // 서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://zex199.dothome.co.kr/Logbook.php";
    private Map<String, String> map;

    public LogbookRequest(String logUser, int logNumber, String logDate, String logLocation, String logLocationType, String logPoint,
                           int logTemperature, String logEnterTime, String logExitTime, String logRestTime, int logWeight,
                           int logEnterPressure, int logExitPressure, int logView, String logWave, int logMaxDepth, int logAveDepth,
                           int logStopFollow, int logSpeedFollow, String logMemo, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("logUser", logUser);
        map.put("logNumber", logNumber + "");
        map.put("logDate", logDate);
        map.put("logLocation", logLocation);
        map.put("logLocationType", logLocationType);
        map.put("logPoint", logPoint);
        map.put("logTemperature", logTemperature + "");
        map.put("logEnterTime", logEnterTime);
        map.put("logExitTime", logExitTime);
        map.put("logRestTime", logRestTime);
        map.put("logWeight", logWeight + "");
        map.put("logEnterPressure", logEnterPressure + "");
        map.put("logExitPressure", logExitPressure + "");
        map.put("logView", logView + "");
        map.put("logWave", logWave);
        map.put("logMaxDepth", logMaxDepth + "");
        map.put("logAveDepth", logAveDepth + "");
        map.put("logStopFollow", logStopFollow + "");
        map.put("logSpeedFollow", logSpeedFollow + "");
        map.put("logMemo", logMemo);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
