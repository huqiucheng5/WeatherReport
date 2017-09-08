package com.hu.weatherreport;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by huqiucheng on 2017/9/8 0008.
 */

public class NetTools {

    private static final String TAG = "NetTools";
    private static final boolean DEBUG = false;
    //    private static String pathHead = "http://mirror.micronavi.cn/weather/mainquery.php?city=";
    private static String pathHead = "aHR0cDovL21pcnJvci5taWNyb25hdmkuY24vd2VhdGhlci9tYWlucXVlcnkucGhwP2NpdHk9";
    private static NetTools netTools;
    private RequestQueue mQueue;

    private NetTools(Context mContext) {
        mQueue = Volley.newRequestQueue(mContext);
    }

    public static NetTools getInstance(Context mContext) {
        if (null == netTools) {
            netTools = new NetTools(mContext);
        }
        return netTools;
    }

    public void getString(String cityName) {
        String path = "";
        try {
            path = getPathHead(pathHead) + URLEncoder.encode(cityName, "utf-8");
            log("path = "+path);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            if (null != listener) {
                listener.onError(RequestNetDataResultListener.PARAMETER_ERROR);
            }
            return;
        }
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                log("onResponse:" + s);
                try {
                    WeatherData weatherData = JSON.parseObject(s, WeatherData.class);
                    log(weatherData.toString());
                    if (null != listener) {
                        listener.onSuccess(weatherData);
                    }
                } catch (Exception e) {
                    if (null != listener) {
                        listener.onError(RequestNetDataResultListener.PARSE_ERROR);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                log("onErrorResponse:" + volleyError.getMessage());
                if (null != listener) {
                    listener.onError(RequestNetDataResultListener.NETWORK_ERROR);
                }
            }
        });
        mQueue.add(stringRequest);
    }


    public void onDestory() {
        if (null != listener) {
            listener = null;
        }

        if (null != mQueue) {
            mQueue.stop();
            mQueue = null;
        }
        if (null != netTools) {
            netTools = null;
        }
    }

    private String getPathHead(String encodedString) {
        return new String(Base64.decode(encodedString, Base64.DEFAULT));
    }

    private void log(String str) {
        if (DEBUG) Log.i(TAG, str);
    }

    private RequestNetDataResultListener listener;

    public void setNetDataResultListener(RequestNetDataResultListener listener) {
        this.listener = listener;
    }

    interface RequestNetDataResultListener {
        int NETWORK_ERROR = 1;
        int PARSE_ERROR = 2;
        int PARAMETER_ERROR = 3;

        void onSuccess(WeatherData weatherData);

        void onError(int errorType);

    }
}
