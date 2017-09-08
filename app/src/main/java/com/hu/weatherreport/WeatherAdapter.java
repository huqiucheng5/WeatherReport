package com.hu.weatherreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by huqiucheng on 2017/9/8 0008.
 */

public class WeatherAdapter extends BaseAdapter {

    private List<WeatherData.ResultsEntity.WeatherDataEntity> weatherDataEntityList;
    private LayoutInflater inflater;

    public WeatherAdapter(List<WeatherData.ResultsEntity.WeatherDataEntity> weatherDataEntityList, Context mContext) {
        this.weatherDataEntityList = weatherDataEntityList;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return weatherDataEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherDataEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_item_weather, null);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_date_weather);
            viewHolder.tvWeather = (TextView) convertView.findViewById(R.id.tv_weather_weather);
            viewHolder.tvWind = (TextView) convertView.findViewById(R.id.tv_wind_weather);
            viewHolder.tvTemp = (TextView) convertView.findViewById(R.id.tv_temp_weather);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        WeatherData.ResultsEntity.WeatherDataEntity weatherDataEntity = weatherDataEntityList.get(position);
        viewHolder.tvDate.setText(weatherDataEntity.getDate());
        viewHolder.tvWeather.setText(weatherDataEntity.getWeather());
        viewHolder.tvWind.setText(weatherDataEntity.getWind());
        viewHolder.tvTemp.setText(weatherDataEntity.getTemperature());
        return convertView;
    }

    static class ViewHolder {
        static TextView tvDate, tvWeather, tvWind, tvTemp;

    }
}
