package com.oy.kanfang;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.oy.activity.BaseActivity;
import com.oy.adapter.XinFangAdapter;
import com.oy.entity.XinFangEntity;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class XinFangActivity extends BaseActivity implements DownUtil.OnDownListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener {
    @BindView(R.id.tv)
    public TextView tv;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.xinfang_lv)
    public ListView xinfang_lv;
    public XinFangAdapter xinFangAdapter;
    public List<XinFangEntity> xinFangEntities ;
    public int cityId;
    public int pageNum = 10;
    public String text;
    public Boolean isBottom = false;
    //底部布局
    private View footerView;
    private ImageView progress_iv;
    private Button bn_more;
    @BindView(R.id.count_tv)
    public TextView count_tv;
    @Override
    protected int setContentId() {
        return R.layout.xinfang_layout;
    }

    @Override
    protected void init() {
        pageNum = 10;
        Intent intent = getIntent();
        cityId = intent.getIntExtra("cityid",1);
        text = intent.getStringExtra("text");
        tv.setText(text);
        xinFangAdapter = new XinFangAdapter(this);
        xinfang_lv.setAdapter(xinFangAdapter);
        xinfang_lv.setOnItemClickListener(this);
        xinfang_lv.setOnScrollListener(this);
        footerView = LayoutInflater.from(this).inflate(R.layout.listview_footer,null);
        xinfang_lv.addFooterView(footerView);
        progress_iv = (ImageView) footerView.findViewById(R.id.progress_iv);
        bn_more = (Button) footerView.findViewById(R.id.bn_more);
        bn_more.setOnClickListener(this);
        //设置imageview动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_progressbar);
        progress_iv.setImageResource(R.drawable.icon_black_progressbar);
        progress_iv.startAnimation(animation);
    }

    @Override
    protected void loadData() {
        String urlStr = String.format(Constants.LOOKING_NEWHOUSE,pageNum,cityId);
        new DownUtil().setOnDownListener(this).downJSON(urlStr);
    }

    @OnClick(R.id.iv_back)
    public void ivClick(){
        setResult(0x456);
        finish();
    }
    @Override
    public Object paresJson(String json) {
        if (json!=null){
            return JSONUtil.getJSONXinFang(json);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
//            isLoad = false;
            xinFangEntities = (List<XinFangEntity>) object;
            count_tv.setText("共有"+JSONUtil.getTotal()+"个楼盘");
            if (isBottom){
                xinFangAdapter.addDatas(xinFangEntities);
            }
            else {
                xinFangAdapter.setDatas(xinFangEntities);
            }

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //新房详细信息
        XinFangEntity xinFangEntity = xinFangEntities.get(position);
        Intent intent = new Intent(XinFangActivity.this,XinLouPanActivity.class);
        intent.putExtra("fid",xinFangEntity.getFid());
        intent.putExtra("fcover",xinFangEntity.getFcover());
        startActivity(intent);

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            case SCROLL_STATE_TOUCH_SCROLL:
                break;
            case SCROLL_STATE_FLING:
                break;
            case SCROLL_STATE_IDLE:
                if (isBottom){
                    pageNum+=10;
//                    isLoad = true;
                    loadData();
                }
                break;
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem+visibleItemCount>=totalItemCount){
            isBottom = true;
        }
        else {
            isBottom = false;
        }
    }

    @Override
    public void onClick(View v) {
        bn_more.setText("正在加载中。。。。");
        loadData();
    }
}
