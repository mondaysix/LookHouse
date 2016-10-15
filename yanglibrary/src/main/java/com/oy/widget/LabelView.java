package com.oy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class LabelView extends View{
    private Paint circlePaint;
    private int radius;

    private Paint txtPaint;
    private String text;
    public LabelView(Context context) {
        this(context,null);
    }

    public LabelView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        radius = 60;
        circlePaint = new Paint();
        circlePaint.setColor(Color.parseColor("#05d8e7"));
        circlePaint.setAntiAlias(true);

        txtPaint = new Paint();
        txtPaint.setTextSize(40);
        txtPaint.setColor(Color.WHITE);
        txtPaint.setStyle(Paint.Style.FILL);
        txtPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (text!=null){
            canvas.drawCircle(getWidth()/2,getHeight()/2,radius,circlePaint);
            canvas.drawText(text,
                    getWidth()/2-txtPaint.measureText(text)/2,
                    getHeight()/2+(txtPaint.descent() - txtPaint.ascent())/2-txtPaint.descent(),
                    txtPaint);
        }
        else {
            this.setVisibility(GONE);
        }
    }
    public  void setText(String text){
        if (text==null){
            this.setVisibility(GONE);
        }
        else {
            this.setVisibility(VISIBLE);
            this.text = text;
            invalidate();
        }

    }
}
