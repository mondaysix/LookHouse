package com.oy.adapter;

import android.content.Context;

import com.oy.entity.NewsXiangQEntity;
import com.oy.kanfang.R;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class NewsXiangQingAdapter extends TypeMoreAdapter<NewsXiangQEntity.ContentBean> {
    public NewsXiangQingAdapter(Context context, int... resids) {
        super(context, R.layout.layout_item_news,R.layout.layout_item_news2);
    }

    @Override
    protected void bindData(ViewHolder viewHolder, NewsXiangQEntity.ContentBean data, int typeView) {
        switch (typeView){
            case 0:
                viewHolder.bindWebView(R.id.content_web,data.getValue());
                break;
            case 1:
                viewHolder.bindImageView(R.id.news_iv,data.getValue(),R.drawable.news_default_img);
                break;
        }
    }
}
