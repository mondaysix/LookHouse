package com.oy.adapter;

import android.content.Context;

import com.oy.entity.CommentEntity;
import com.oy.kanfang.R;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CommentAdapter extends TypeMoreAdapter<CommentEntity>{
    public CommentAdapter(Context context, int... resids) {
        super(context, R.layout.comment_item_layout);

    }

    @Override
    protected void bindData(ViewHolder viewHolder, CommentEntity data, int typeView) {
        viewHolder.bindImageView(R.id.head_iv, data.getHead(), R.drawable.icon_default_avatar);
        viewHolder.bindTextView(R.id.nickname_tv, data.getNick());
        viewHolder.bindTextView(R.id.region_tv,data.getRegion());
        viewHolder.bindTextView(R.id.time_tv,data.getTime());
        viewHolder.bindTextView(R.id.content_tv,data.getContent());
        if (data.getIsreply()!=0){
            viewHolder.bindTextView(R.id.reply_tv,data.getReplynick()+":"+data.getReplycontent());
        }

    }
}
