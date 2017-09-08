package com.hu.weatherreport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetTools.RequestNetDataResultListener {


    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = false;
    private TextView tvTime, tvCity, tvPm;
    private ListView listviewLife, listviewWeather;
    private List<WeatherData.ResultsEntity.IndexEntity> indexEntityList;
    private List<WeatherData.ResultsEntity.WeatherDataEntity> weatherDataEntityList;
    private LifeAdapter lifeAdapter;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvCity = (TextView) findViewById(R.id.tv_city);
        tvPm = (TextView) findViewById(R.id.tv_pm);
        listviewLife = (ListView) findViewById(R.id.listview_life);
        listviewWeather = (ListView) findViewById(R.id.listview_weather);
    }

    private void initData() {
        indexEntityList = new ArrayList<>();
        weatherDataEntityList = new ArrayList<>();
        lifeAdapter = new LifeAdapter(indexEntityList, this);
        listviewLife.setAdapter(lifeAdapter);
        weatherAdapter = new WeatherAdapter(weatherDataEntityList, this);
        listviewWeather.setAdapter(weatherAdapter);
        NetTools.getInstance(this).setNetDataResultListener(this);
        NetTools.getInstance(this).getString("深圳");
    }

    @Override
    public void onSuccess(WeatherData weatherData) {
        log(weatherData.toString());
        if (0 == weatherData.getError()) {
            tvTime.setText(weatherData.getDate());
            tvCity.setText(weatherData.getResults().get(0).getCurrentCity());
            tvPm.setText(weatherData.getResults().get(0).getPm25());
            if (indexEntityList.size() > 0) {
                indexEntityList.clear();
            }
            indexEntityList.addAll(weatherData.getResults().get(0).getIndex());
            lifeAdapter.notifyDataSetChanged();
            if (weatherDataEntityList.size() > 0) {
                weatherDataEntityList.clear();
            }
            weatherDataEntityList.addAll(weatherData.getResults().get(0).getWeather_data());
            weatherAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "获取数据失败!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(int errorType) {
        log("onError: " + errorType);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetTools.getInstance(this).onDestory();
    }

    private void log(String str) {
        if (DEBUG) Log.i(TAG, str);
    }
}
