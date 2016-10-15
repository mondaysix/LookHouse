package com.oy.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.oy.entity.HouseEntity;
import com.oy.kanfang.R;

import java.util.List;

import butterknife.BindView;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by Administrator on 2016/9/29.
 */
public class HouseLouPanFragment extends BaseFragment {
    public HouseEntity datas;
    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.discount_tv)
    TextView discount_tv;
    @BindView(R.id.title_tv2)
    TextView title_tv2;
    @BindView(R.id.summary_tv)
    TextView summary_tv;
    @BindView(R.id.huxing_tv)
    TextView huxing_tv;
    @BindView(R.id.huxing_tv2)
    TextView huxing_tv2;
    @BindView(R.id.huxing_iv1)
    ImageView huxing_iv1;
    @BindView(R.id.huxing_iv2)
    ImageView huxing_iv2;
    @BindView(R.id.ll_info)
    LinearLayout ll_info;
    @Override
    public int getLayoutId() {
        return R.layout.house_loupan_layout;
    }
    @Subscribe(threadMode = ThreadMode.MainThread, priority = 100, sticky = true)
    public void onEventMainThread(HouseEntity data) {
        this.datas = data;
        title_tv.setText(datas.getName());
        discount_tv.setText(datas.getDiscount());
        title_tv2.setText(datas.getTitle());
        summary_tv.setText(datas.getSummary());
        //主力户型
        huxing_tv.setText(datas.getUnitlist().getData().get(0).getName());
        huxing_tv2.setText(datas.getUnitlist().getData().get(1).getName());
        Glide.with(getActivity()).load(datas.getUnitlist().getData().get(0).getUrl()).into(huxing_iv1);
        Glide.with(getActivity()).load(datas.getUnitlist().getData().get(0).getUrl()).into(huxing_iv2);
        //楼盘详细信息
        Log.d("msg","----->"+datas.getInfo().get(0).toString());

        /*for (int i = 0; i <datas.getInfo().size() ; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(datas.getInfo().get(i));
            Log.d("msg",datas.getInfo().get(i));
            tv.setTextColor(Color.parseColor("#bebaba"));
            tv.setTextSize(15);
            tv.measure(0, 0);

            ll_info.addView(tv);
        }*/
    }
}