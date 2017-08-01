package com.cn.arouter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ${qsh} on 2017/7/24.
 */

public class MyTestView extends View {
    //扩展圆宽度取控件的长度最小值
    private float minRadius;
    //中心圆画笔
    private Paint mCenterPaint;
    //中心圆画笔颜色
    private int mCenterPaintColor = Color.parseColor("#00ff00");
    //透明度
    private int mAlpha = 255;
    //扩散圆画笔
    private Paint mPaint;
    //扩散圆画笔颜色
    private int mPaintColor = Color.parseColor("#00dd00");
    //圆心X
    private float mCenterX;
    //圆心Y
     private float mCenterY;
    //中心圆半径
     private float mInnerCircleRadius = 50;
    //扩散圆扩散宽度
     private float mDiffuseWidth = 0;
    //是否开始扫描
     private Boolean startDiffseBoolean = true;


    public MyTestView(Context context) {
        this(context,null);
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //在构造函数中扩散圆画笔初始化
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //防抖动
        mPaint.setDither(true);
        mPaint.setColor(mPaintColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(4);
        //中心画笔初始化
        mCenterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //防抖动
        mCenterPaint.setDither(true);
        mCenterPaint.setStyle(Paint.Style.FILL);
        mCenterPaint.setColor(mCenterPaintColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAlpha(mAlpha);
        //画扩散圆
        mAlpha = mAlpha - 1;
        mDiffuseWidth = mDiffuseWidth + 2;
        if (mAlpha <= 0 || mDiffuseWidth >= minRadius) {
            mAlpha = 255;
            mDiffuseWidth = mInnerCircleRadius;
        }
        //画扩散圆
        canvas.drawCircle(mCenterX, mCenterY, mDiffuseWidth, mPaint);
        //画中心圆
        canvas.drawCircle(mCenterX, mCenterY, mInnerCircleRadius, mCenterPaint);
        if (startDiffseBoolean) {
            postInvalidate();
        }
    }

    @Override
    public void postInvalidate() {
        if (hasWindowFocus()) {
            super.postInvalidate();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取到中心圆坐标
        mCenterX = w / 2;
        mCenterY = h / 2;
        minRadius = Math.min(mCenterX, mCenterY);
        Log.d("print","-------------->");
    }


}
