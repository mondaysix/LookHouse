package com.oy.kanfang;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.activity.BaseActivity;
import com.oy.entity.HouseEntity;
import com.oy.fragment.HomeFragment;
import com.oy.fragment.HouseCommentFragment;
import com.oy.fragment.HouseLouPanFragment;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by Administrator on 2016/9/29.
 */
public class XinLouPanActivity extends BaseActivity implements DownUtil.OnDownListener{
    String fid,fcover;
    @BindView(R.id.head_iv)
    public ImageView head_iv;
    public HouseEntity houseEntity;

    @BindView(R.id.tv_count)
    public TextView tv_count;
    @BindView(R.id.btn_reply)
    public Button btn_reply;
    @BindView(R.id.btn_info)
    public Button btn_info;
    public int totalNum= 0;
    @Override
    protected int setContentId() {
        return R.layout.xinloupan_layout;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        fid = intent.getStringExtra("fid");
        Log.d("msg","----fid"+fid);
        fcover = intent.getStringExtra("fcover");
        Glide.with(this).load(fcover).into(head_iv);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.infor_fragment, new HouseLouPanFragment())
                .commit();
    }

    @Override
    protected void loadData() {
        String url = String.format(Constants.NEW_HOUSE_INFO, fid);
        new DownUtil().setOnDownListener(this).downJSON(url);
    }

    @Override
    public Object paresJson(String json) {
        if (json!=null){

            return JSONUtil.getJSONHouse(json);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
             houseEntity = (HouseEntity) object;
            for (int i = 0;i<houseEntity.getPic().size();i++){
                HouseEntity.PicBean picBean = houseEntity.getPic().get(i);
                totalNum+=picBean.getNum();
            }
            tv_count.setText("" + totalNum);
            btn_reply.setText("评论("+houseEntity.getCommentnum()+")");

            EventBus.getDefault().postSticky(houseEntity);
        }
    }

    @OnClick(R.id.btn_reply)
    public void replyClick(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.infor_fragment, new HouseCommentFragment())
                .commit();
    }
    @OnClick(R.id.btn_info)
    public void infoClick(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.infor_fragment, new HouseLouPanFragment())
                .commit();
        loadData();


    }
}
