package com.oy.kanfang;

import android.app.Application;

import com.oy.util.SharedUtil;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedUtil.init(this);
    }
}
