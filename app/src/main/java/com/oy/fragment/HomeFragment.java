package com.oy.fragment;

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

import com.oy.adapter.MyNewAdapter;
import com.oy.entity.CityEntity;
import com.oy.entity.HeaderEntity;
import com.oy.entity.ZiXunEntity;
import com.oy.kanfang.ChoiceCityActivity;
import com.oy.kanfang.NewsActivity;
import com.oy.kanfang.R;
import com.oy.kanfang.XinFangActivity;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;
import com.oy.util.SharedUtil;
import com.oy.widget.HeaderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class HomeFragment extends BaseFragment implements DownUtil.OnDownListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener {
    //标题栏
    @BindView(R.id.btn_city)
    public Button btn_city;
    public  String cityName="北京";
    public int cityId = 1;
    public List<HeaderEntity> headerEntities;
    //默认listview显示页数10
    public int pageNum = 10;
    public boolean isBottom = false;
    public boolean isLoad= false;
    @BindView(R.id.lv_zixun)
    public ListView lv_zixun;
    public MyNewAdapter myNewAdapter;
    public List<ZiXunEntity> zixunList;
    //头部viewPager组合控件
    private HeaderView headerView;
    private View headerView2;
    //八个按钮
    private Button xinfang_btn;
    //    //底部布局
    private View footerView;
    private ImageView progress_iv;
    private Button bn_more;
    @Override
    public int getLayoutId() {
        return R.layout.layout_fragment;
    }
    /**
     * 初始化
     * @param view
     */
    @Override
    public void init(View view) {
        headerEntities = new ArrayList<>();
        //从共享文件中取出数据
        String Name = SharedUtil.getString("cityName");
        int Id = SharedUtil.getInt("cityId");
        if (Name !=null && Id!=-1){
            this.cityName = Name;
            this.cityId = Id;
            btn_city.setText(this.cityName);
        }
        myNewAdapter = new MyNewAdapter(getActivity());
        lv_zixun.setAdapter(myNewAdapter);
        lv_zixun.setOnItemClickListener(this);
        //设置头部控件
        headerView = new HeaderView(getActivity());
        headerView.setFragmentManager(getChildFragmentManager());
        lv_zixun.addHeaderView(headerView);
        //设置8个按钮布局
        initButton();
        lv_zixun.addHeaderView(headerView2);
        //设置底部视图
        footerView = LayoutInflater.from(getContext()).inflate(R.layout.listview_footer,null);
        lv_zixun.addFooterView(footerView);
        progress_iv = (ImageView) footerView.findViewById(R.id.progress_iv);
        bn_more = (Button) footerView.findViewById(R.id.bn_more);
        bn_more.setOnClickListener(this);
        //设置imageview动画
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_progressbar);
        progress_iv.setImageResource(R.drawable.icon_black_progressbar);
        progress_iv.startAnimation(animation);


    }

    private void initButton() {
        headerView2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_headerview2,null);
        xinfang_btn = (Button) headerView2.findViewById(R.id.xinfang_btn);




    }

    @Override
    public void setListener() {
        lv_zixun.setOnScrollListener(this);
        xinfang_btn.setOnClickListener(this);
    }
    @Override
    public void loadDatas() {
        String url = String.format(Constants.FIRST_PAGE_LISTVIEW,pageNum,cityId);
        new DownUtil().setOnDownListener(this).downJSON(url);
        //加载头部
        headerView.setCityId(cityId);
    }
    /**
     * 点击跳转到选择城市页面
     */
    @OnClick(R.id.btn_city)
    public void btnClick(Button button) {
        startActivityForResult(new Intent(getActivity(), ChoiceCityActivity.class), 0x123);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0x123 && resultCode == 0x456){
            CityEntity cityEntity = (CityEntity) data.getSerializableExtra("cityEntity");
            //保存到共享参数中
            cityId = cityEntity.getCityid();
            cityName = cityEntity.getCityname();
            SharedUtil.putString("cityName", cityName);
            SharedUtil.putInt("cityId", cityId);
            btn_city.setText(cityName);
            //重新加载数据
            pageNum = 10;
            loadDatas();
        }

    }
    /**
     * listview列表
     * @param json
     * @return
     */
    @Override
    public Object paresJson(String json) {
        if (json!=null){
            return JSONUtil.getJSONZiXun(json);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
            zixunList = (List<ZiXunEntity>) object;
            if (isBottom){
                myNewAdapter.addNewDatas(zixunList);
            }
            else {
                myNewAdapter.setDatas(zixunList);
            }
            isLoad = false;


        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==zixunList.size()){
            position = zixunList.size() - 1;
        }
        String newsId = zixunList.get(position).getId();
        String commentId = zixunList.get(position).getCommentid();
        int commentCount = zixunList.get(position).getCommentcount();
        //跳转新闻详情页
        Intent intent = new Intent(new Intent(getActivity(), NewsActivity.class));
        intent.putExtra("newsId", newsId);
        intent.putExtra("commentId",commentId);
        intent.putExtra("commentCount",commentCount);
        startActivity(intent);
    }

    /**
     * listview滚动事件
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            case SCROLL_STATE_TOUCH_SCROLL:
                break;
            case SCROLL_STATE_FLING:
                break;
            case SCROLL_STATE_IDLE:
                if (isBottom && !isLoad){
                    pageNum+=10;
                    isLoad = true;
                    loadDatas();
                }
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int lastItem = firstVisibleItem+visibleItemCount;
        if (lastItem>=totalItemCount){
            isBottom = true;
        }
        else{
            isBottom = false;
        }
    }

    /**
     * 八个按钮点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String text = button.getText().toString();
        switch (v.getId()) {
            case R.id.xinfang_btn:
                Intent intent = new Intent(getActivity(), XinFangActivity.class);
                intent.putExtra("cityid", cityId);
                intent.putExtra("text", text);
                startActivity(intent);
                break;
            case R.id.bn_more:
                bn_more.setText("正在加载中。。。。");
                loadDatas();
                break;
        }
    }
}
