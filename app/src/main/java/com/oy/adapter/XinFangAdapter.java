package com.oy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oy.entity.XinFangEntity;
import com.oy.kanfang.R;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class XinFangAdapter extends TypeMoreAdapter<XinFangEntity> {
    public Context context;
    public XinFangAdapter(Context context, int... resids) {
        super(context, R.layout.xinfang_item_layout);
        this.context = context;
    }

    @Override
    protected void bindData(ViewHolder viewHolder, XinFangEntity data, int typeView) {
        viewHolder.bindImageView(R.id.xinfang_iv, data.getFcover(), R.drawable.news_default_img);
        viewHolder.bindTextView(R.id.tv_fname,data.getFname());
        viewHolder.bindTextView(R.id.tv_faddress,data.getFaddress());
        viewHolder.bindTextView(R.id.tv_fregion,data.getFregion());
        viewHolder.bindTextView(R.id.tv_price, data.getFpricedisplaystr());
        int count = data.getBookmark().size();
        LinearLayout ll = (LinearLayout) viewHolder.getView(R.id.ll);
        //连线imageview
        ImageView lianxian_iv= (ImageView) viewHolder.getView(R.id.lianxian_iv);
        if (data.getHas_agent()==1){
            lianxian_iv.setVisibility(View.VISIBLE);
        }
        else {
            lianxian_iv.setVisibility(View.INVISIBLE);
        }

        //新房图片
        if (data.getHas_agent()==0){
            lianxian_iv.setVisibility(View.INVISIBLE);
        }
        else {
            lianxian_iv.setVisibility(View.VISIBLE);
        }
        ll.removeAllViews();
        for (int i = 0;i<count;i++){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 10, 0);
            TextView tv = new TextView(context);
            tv.setText(data.getBookmark().get(i).getTag());
            tv.setLayoutParams(lp);
            tv.setPadding(5,5,5,5);
            tv.setTextSize(10);
            if (i == 0){
                tv.setBackgroundColor(Color.RED);
                ll.addView(tv);
                continue;
            }
            if (i == 1){
                tv.setBackgroundColor(Color.GRAY);
                ll.addView(tv);
            }
            if (i == 2){
                tv.setBackgroundColor(Color.BLUE);
                ll.addView(tv);
                continue;
            }

        }
    }
}
