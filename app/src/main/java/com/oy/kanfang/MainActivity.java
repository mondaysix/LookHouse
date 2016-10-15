package com.oy.kanfang;

import android.widget.RadioGroup;

import com.oy.activity.BaseActivity;
import com.oy.fragment.HomeFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.rg)
    RadioGroup rg;

    @Override
    protected int setContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onItemListener() {
        rg.setOnCheckedChangeListener(this);
        rg.getChildAt(0).performClick();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rg_home:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_content,new HomeFragment())
                        .commit();
                break;
            case R.id.rg_discover:
                break;
            case R.id.rg_message:
                break;
            case R.id.rg_mine:
                break;
        }
    }
}
