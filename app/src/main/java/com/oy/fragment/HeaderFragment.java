package com.oy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.oy.entity.HeaderEntity;
import com.oy.kanfang.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class HeaderFragment extends BaseFragment {
    @BindView(R.id.iv_vp)
    public ImageView iv_vp;
    @BindView(R.id.tv_vp)
    public TextView tv_vp;
    public static Fragment getInstance(HeaderEntity headerEntity){
        HeaderFragment headerFragment = new HeaderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("headerentiry",headerEntity);
        headerFragment.setArguments(bundle);
        return headerFragment;

    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_headerview;
    }

    @Override
    protected void getDatas(Bundle bundle) {
        HeaderEntity headerEntity = (HeaderEntity) bundle.getSerializable("headerentiry");
        Glide.with(getActivity())
                .load(headerEntity.getPicurl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(0.1f)
                .placeholder(R.drawable.news_default_img)
                .crossFade()
                .into(iv_vp);
        tv_vp.setText(headerEntity.getTitle());
    }
}
