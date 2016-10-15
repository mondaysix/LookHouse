package com.oy.kanfang;

import android.content.Intent;
import android.widget.ImageView;

import com.oy.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.iv_welcome)
    public ImageView iv;
    @Override
    protected int setContentId() {
        return R.layout.layout_welcome;
    }
    @Override
    protected void init() {
        /*Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                WelcomeActivity.this.finish();
            }
        },1000);*/
        iv.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转到主页面
                startActivityForAnimation(new Intent(WelcomeActivity.this, MainActivity.class), R.anim.anim_activity_in_right, R.anim.anim_activity_out_left);
                finish();
            }
        }, 2000);

    }

    @Override

    public void onDestroy() {

        super.onDestroy();

    }

}

