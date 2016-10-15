package com.oy.kanfang;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.oy.activity.BaseActivity;
import com.oy.adapter.CommentAdapter;
import com.oy.entity.CommentEntity;
import com.oy.util.Constants;
import com.oy.util.DownUtil;
import com.oy.util.JSONUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CommentActivity extends BaseActivity implements DownUtil.OnDownListener {
    public String commentId;
    @BindView(R.id.title_tv)
    public TextView title_tv;
    @BindView(R.id.iv_back)
    public ImageView iv_back;
    @BindView(R.id.comment_lv)
    public ListView comment_lv;
    public CommentAdapter commentAdapter;
    @Override
    protected int setContentId() {
        return R.layout.comment_layout;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        title_tv.setText(title);
        commentId = intent.getStringExtra("commentid");
        commentAdapter = new CommentAdapter(this);
        comment_lv.setAdapter(commentAdapter);
    }

    @Override
    protected void loadData() {
        String urlStr = String.format(Constants.NEWS_COMMENT,commentId);
        new DownUtil().setOnDownListener(this).downJSON(urlStr);
    }

    @OnClick(R.id.iv_back)
    public void imageOnClick(){
        setResult(0x456);
        finish();
    }

    @Override
    public Object paresJson(String json) {
        if (json!=null){
            return JSONUtil.getJSONComment(json);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object!=null){
            List<CommentEntity> commentEntities = (List<CommentEntity>) object;
            commentAdapter.setDatas(commentEntities);
        }

    }
}
