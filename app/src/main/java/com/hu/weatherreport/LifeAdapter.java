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

public class LifeAdapter extends BaseAdapter {

    private List<WeatherData.ResultsEntity.IndexEntity> indexEntityList;
    private LayoutInflater inflater;

    public LifeAdapter(List<WeatherData.ResultsEntity.IndexEntity> indexEntityList, Context mContext) {
        this.indexEntityList = indexEntityList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return indexEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return indexEntityList.get(position);
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
            convertView = inflater.inflate(R.layout.listview_item_life, null);
            viewHolder.tvTitleLife = (TextView) convertView.findViewById(R.id.tv_title_life);
            viewHolder.tvFeelLife = (TextView) convertView.findViewById(R.id.tv_feel_life);
            viewHolder.tvClothLife = (TextView) convertView.findViewById(R.id.tv_cloth_life);
            viewHolder.tvSuggestionLife = (TextView) convertView.findViewById(R.id.tv_suggestion_life);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        WeatherData.ResultsEntity.IndexEntity indexEntity = indexEntityList.get(position);
        viewHolder.tvTitleLife.setText(indexEntity.getTitle());
        viewHolder.tvFeelLife.setText(indexEntity.getZs());
        viewHolder.tvClothLife.setText(indexEntity.getTipt());
        viewHolder.tvSuggestionLife.setText(indexEntity.getDes());
        return convertView;
    }

    static class ViewHolder {
        static TextView tvTitleLife, tvFeelLife, tvClothLife, tvSuggestionLife;

    }
}
