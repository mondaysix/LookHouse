package com.oy.adapter;

import android.content.Context;

import com.oy.entity.ZiXunEntity;
import com.oy.kanfang.R;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class MyNewAdapter extends TypeMoreAdapter<ZiXunEntity> {
    public MyNewAdapter(Context context) {
        super(context, R.layout.layout_zixun1_item, R.layout.layout_zixun2_item);
    }

    @Override
    protected void bindData(ViewHolder viewHolder, ZiXunEntity data, int typeView) {
        switch (typeView){
            case 0:
                viewHolder
                        .bindTextView(R.id.title_tv, data.getTitle())
                        .bindTextView(R.id.summary_tv, data.getSummary())
                        .bindImageView(R.id.image, data.getThumbnail(), R.drawable.news_default_img);
                break;
            case 1:
                viewHolder
                        .bindTextView(R.id.tv_title, data.getTitle())
                        .bindImageView(R.id.image, data.getGroupthumbnail(), R.drawable.news_three_default_img);
                break;
        }
    }
}
