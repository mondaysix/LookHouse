package com.oy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class SideBar extends View {
    // 26个字母
    public static String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private Paint paint;
    private int singleHeight;
    private int index = -1;
    private OnSlibBarListener onListener;

    public void setOnListener(OnSlibBarListener onListener) {
        this.onListener = onListener;
    }
    public SideBar(Context context) {
        this(context,null);
    }

    public SideBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#05d8e7"));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(2);
        paint.setTextSize(40);

        //获得每个文本的高度
        singleHeight = (int) (paint.descent()-paint.ascent());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0;i<letters.length;i++){
            canvas.drawText(letters[i],
                    getWidth()/2 - paint.measureText(letters[i])/2,
                    (i + 1) * singleHeight,
                    paint);
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = setSize(1,widthMeasureSpec);
        int height = setSize(2,heightMeasureSpec);
        setMeasuredDimension(width,height);

    }
    public int setSize(int type,int srsize){
        //系统推荐的大小和模式
        int size = MeasureSpec.getSize(srsize);
        int mode = MeasureSpec.getMode(srsize);
        switch (mode){
            case MeasureSpec.EXACTLY:
                return size;
            case MeasureSpec.AT_MOST:
                switch (type){
                    case 1:
                        //测量宽度
                        return (int) (paint.measureText(letters[0])+getPaddingLeft()+getPaddingRight());
                    case 2:
                        //测量高度
                        return singleHeight*letters.length+getPaddingBottom()+getPaddingTop();
                }
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        return size;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setTouchEvent(event);
                break;
            case MotionEvent.ACTION_MOVE:
                setTouchEvent(event);
                break;
            case MotionEvent.ACTION_UP:
                index = -1;
                invalidate();
                if (onListener!=null){
                    onListener.setUnTouch();
                }
                break;
        }
        return true;
    }

    private void setTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        int id = y/singleHeight;
        if (id < 0){
            id = 0;
        }
        if (id>=letters.length - 1){
            id = letters.length - 1;
        }
        if (onListener!=null){
            onListener.setTextListener(letters[id],id);
        }
        index = id;
        invalidate();

    }
    public interface OnSlibBarListener{
        void setTextListener(String text, int id);
        void setUnTouch();
    }

}
