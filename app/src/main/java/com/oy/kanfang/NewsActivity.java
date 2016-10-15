package com.oy.kanfang;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.oy.activity.BaseActivity;
import com.oy.adapter.NewsXiangQingAdapter;
import com.oy.entity.NewsXiangQEntity;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class NewsActivity extends BaseActivity implements DownUtil.OnDownListener {
    @BindView(R.id.news_lv)
    public ListView news_lv;
    private NewsXiangQingAdapter newsAdapter;
    //新闻编号、新闻评论数和id、标题
    private String newsId;
    private String commentId;
    private int commentCount;
    private String title;
    private NewsXiangQEntity newsXiangQEntity;
    private View viewHeader;
    @BindView(R.id.btn_comment)
    public Button btn_comment;
    @Override
    protected int setContentId() {
        return R.layout.xiangqi_layout;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsId");
        //设置评论数
        commentCount = intent.getIntExtra("commentCount",1);
        btn_comment.setText(""+commentCount);
        //获得评论的id
        commentId = intent.getStringExtra("commentId");
        viewHeader = LayoutInflater.from(this).inflate(R.layout.layout_item_news_header,null);
        newsAdapter = new NewsXiangQingAdapter(this);
        news_lv.setAdapter(newsAdapter);
        news_lv.addHeaderView(viewHeader);
    }

    @Override
    protected void loadData() {
        String urlStr = String.format(Constants.NEWS_DETAIL, newsId);
        new DownUtil().setOnDownListener(this).downJSON(urlStr);

    }

    @Override
    public Object paresJson(String json) {
        if (json!=null){
            NewsXiangQEntity jsonXiangQ = JSONUtil.getJSONXiangQ(json);
            return jsonXiangQ;
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
            newsXiangQEntity = (NewsXiangQEntity) object;
            newsAdapter.setDatas(newsXiangQEntity.getContent());
            TextView title_tv = (TextView) viewHeader.findViewById(R.id.title_tv);
            title_tv.setText( newsXiangQEntity.getTitle());
            title = newsXiangQEntity.getTitle().toString();
            TextView source_tv = (TextView) viewHeader.findViewById(R.id.source_tv);
            source_tv.setText(newsXiangQEntity.getSource());
            TextView time_tv = (TextView) viewHeader.findViewById(R.id.time_tv);
            time_tv.setText(newsXiangQEntity.getTime());

        }
    }
    /**
     * 返回上一页
     */
    @OnClick(R.id.iv_back)
    public void btnClick(){
        setResult(0x456,null);
        finish();
    }
    @OnClick(R.id.btn_comment)
    public void commentClick(){
        //跳转到新闻评论页面
        Intent intent = new Intent(this,CommentActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("commentid", commentId);
        startActivityForResult(intent, 0x123);
    }
}
