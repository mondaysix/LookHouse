package com.oy.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.oy.entity.HeaderEntity;
import com.oy.fragment.HeaderFragment;
import com.oy.kanfang.R;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;
import com.oy.widget.loopviewpager.LoopViewPager;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class HeaderView extends FrameLayout implements DownUtil.OnDownListener, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private int cityId;
    private FragmentManager fragmentManager;
    private MyAdadper myAdapter;
    private  List<HeaderEntity> datas;
    private LinearLayout point_ll;
    public HeaderView(Context context) {
        this(context,null);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_header,this,true);
        viewPager = (ViewPager) findViewById(R.id.vp_header);
        point_ll = (LinearLayout) findViewById(R.id.point_ll);
    }
    public void setCityId(int cityId){
        this.cityId = cityId;
        loadDatas();
    }
    /**
     * 下载数据
     */
   private void loadDatas(){
       String url = String.format(Constants.FIRST_PAGE_WEBVIEW,cityId);
       new DownUtil().setOnDownListener(this).downJSON(url);

   }

    @Override
    public Object paresJson(String json) {
        if (json!=null){
            return JSONUtil.getJSONHeader(json);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
             datas = (List<HeaderEntity>) object;
            if (fragmentManager!=null){
                myAdapter = new MyAdadper(fragmentManager,datas);
                viewPager.setAdapter(myAdapter);
            }
            point_ll.removeAllViews();
            for (int i = 0;i<datas.size();i++){
                ImageView iv = new ImageView(getContext());
                LinearLayout.LayoutParams lp ;
                if (i == 0){
                    iv.setImageResource(R.drawable.page);

                }
                else {
                    iv.setImageResource(R.drawable.page_now);
                }
                iv.setTag(i);
                point_ll.addView(iv);
                lp = (LinearLayout.LayoutParams) iv.getLayoutParams();
                lp.setMargins(5,8,10,0);
                iv.setLayoutParams(lp);
            }
            //viewpager设置事件
            viewPager.addOnPageChangeListener(this);

        }
    }

    /**
     * ViewPager事件
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0;i<datas.size();i++){
            ImageView iv = (ImageView) point_ll.findViewWithTag(i);
            if (i==position){
                iv.setImageResource(R.drawable.page);
            }
            else {
                iv.setImageResource(R.drawable.page_now);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private static class MyAdadper extends FragmentStatePagerAdapter{
        private List<HeaderEntity> headEntities;
        public MyAdadper(FragmentManager fm, List<HeaderEntity> headEntities) {
            super(fm);
            this.headEntities = headEntities;
    }

        @Override
        public Fragment getItem(int position) {
            position = LoopViewPager.toRealPosition(position,getCount());
            return HeaderFragment.getInstance(headEntities.get(position%getCount()));
        }

        @Override
        public int getCount() {
            return headEntities.size();
        }
    }
    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

}
