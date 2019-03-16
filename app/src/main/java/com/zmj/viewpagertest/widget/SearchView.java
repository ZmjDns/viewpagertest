package com.zmj.viewpagertest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.zmj.viewpagertest.R;

import java.util.concurrent.Executors;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/14
 * Description :自定义编辑搜索框
 */
public class SearchView extends AppCompatTextView {

    private float imageWidth = 0;
    private float textSize = 0;
    private int textColor = 0xFF000000;
    private Drawable mDrawable;
    private Paint mPaint;

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initResource(context,attrs);
        initPaint();
    }

    private void initResource(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchView);
        float density = context.getResources().getDisplayMetrics().density;
        imageWidth = typedArray.getDimension(R.styleable.SearchView_imageWidth,18 * density + 0.5f);
        textColor = typedArray.getColor(R.styleable.SearchView_textColor,0xFF848484);
        textSize = typedArray.getDimension(R.styleable.SearchView_textSize,14 * density + 0.5f);
        typedArray.recycle();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSearchIcon(canvas);
    }

    private void drawSearchIcon(Canvas canvas) {
        if (this.getText().toString().length() == 0){
            float textWidth = mPaint.measureText("请输入");
            float textHeight = getFontLeading(mPaint);

            float dx = (getWidth() - imageWidth - textWidth - 8) / 2;
            float dy = (getHeight() - imageWidth) / 2;

            canvas.save();
            canvas.translate(getScrollX() + dx,getScrollY() + dy);
            if (mDrawable != null){
                mDrawable.draw(canvas);
            }
            canvas.drawText("请输入",getScrollX() + imageWidth + 8,getScrollY() + (getHeight() - (getHeight() - textHeight) / 2) - mPaint.getFontMetrics().bottom - dy,mPaint);
            canvas.restore();
        }
    }

    private float getFontLeading(Paint mPaint) {
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mDrawable == null){
            try {
             mDrawable = getContext().getResources().getDrawable(R.mipmap.search);
             mDrawable.setBounds(0,0,(int) imageWidth,(int) imageWidth);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mDrawable != null){
            mDrawable.setCallback(null);
            mDrawable = null;
        }
        super.onDetachedFromWindow();
    }
}
