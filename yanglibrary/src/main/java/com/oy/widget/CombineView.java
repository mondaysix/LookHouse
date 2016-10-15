package com.oy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.oy.yanglibrary.R;


/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class CombineView  extends FrameLayout implements SideBar.OnSlibBarListener {
    private SideBar slibBarView;
    private LabelView labelView;
    private TextOnSelectedListener textOnlistener;
    public CombineView(Context context) {
        this(context,null);
    }
    public void setTextChangeListener(TextOnSelectedListener textOnlistener){
        this.textOnlistener = textOnlistener;
    }
    public CombineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CombineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sidebar_layout,this,true);
        slibBarView = (SideBar) findViewById(R.id.sbv);
        labelView = (LabelView) findViewById(R.id.lv);
        slibBarView.setOnListener(this);
    }

    @Override
    public void setTextListener(String text, int id) {
        labelView.setText(text);
        if(textOnlistener!=null){
            textOnlistener.getSelectText(text);
        }
    }

    @Override
    public void setUnTouch() {
        labelView.setText(null);
    }
    public interface TextOnSelectedListener{
        void getSelectText(String str);
    }
}