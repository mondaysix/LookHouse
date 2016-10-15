package com.oy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oy.entity.CityEntity;
import com.oy.kanfang.R;

import java.util.ArrayList;
import java.util.List;

import de.halfbit.pinnedsection.PinnedSectionListView;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class CityAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

    private Context context;
    private List<CityEntity> cityList ;
    public CityAdapter(Context context){
        this.context = context;
        cityList = new ArrayList<>();
    }
    public void setCities(List<CityEntity> cities){
        this.cityList = cities;
        this.notifyDataSetChanged();
    }
    public int queryId(String str){
       for (int i = 0;i<cityList.size();i++){
           if (cityList.get(i).getType() == 0){
               if (cityList.get(i).getCityname().equals(str)){
                   return i;
               }
           }

       }
        return -1;
    }
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == 0;
    }
    @Override
    public int getItemViewType(int position) {
        return cityList.get(position).getType();
    }
    /**
     * 两种布局
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public boolean isEnabled(int position) {
        return cityList.get(position).getType()==1;
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public Object getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView!=null){
            viewHolder = (ViewHolder) convertView.getTag();
        }
        else {
            viewHolder = new ViewHolder();
            /**
             * 加载标签
             */
            if (cityList.get(position).getType()==0){
                convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_label,null);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_catalog);
            }
            else {
                convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_city,null);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_title);
            }
            convertView.setTag(viewHolder);
        }
        viewHolder.tv.setText( cityList.get(position).getCityname());
        return convertView;
    }
    public class ViewHolder {
        TextView tv;
    }
}
