package com.oy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentId());
        //注册activity
        ButterKnife.bind(this);
        init();
        loadData();
        onItemListener();
    }
    /**
     * 布局id
     * @return
     */
    protected abstract int setContentId();
    protected  void loadData(){};
    protected  void init(){};
    protected  void onItemListener(){};
    /**
     * activity的跳转
     * @param intent
     * @param srcid
     * @param desid
     */
    protected void startActivityForAnimation(Intent intent,int srcid,int desid){
        startActivity(intent);
        overridePendingTransition(srcid,desid);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
