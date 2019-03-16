package com.zmj.viewpagertest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zmj.viewpagertest.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/16
 * Description :自定义banner圆点
 */
public class BannerIndicator extends View {

    private int number;
    private int position;
    private Paint paint = new Paint();
    private int selectorColor;
    private int unSelectColor;
    private float radius;
    private float space;

    public BannerIndicator(Context context) {
        super(context);
    }

    public BannerIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BannerIndicator);
        this.selectorColor = typedArray.getColor(R.styleable.BannerIndicator_selectColor, Color.RED);
        this.unSelectColor = typedArray.getColor(R.styleable.BannerIndicator_unSelectColor,Color.BLACK);
        this.radius = typedArray.getDimension(R.styleable.BannerIndicator_radius,10);
        this.space = typedArray.getDimension(R.styleable.BannerIndicator_space,20);
        typedArray.recycle();
    }

    {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startPosition = getWidth() / 2 - (radius * 2 * number + space * (number - 1)) / 2;
        canvas.save();

        for (int i = 0; i < number; i++){
            if (i == position){
                paint.setColor(selectorColor);
            }else {
                paint.setColor(unSelectColor);
            }

            canvas.drawCircle(startPosition + radius * (2 * i + 1) + i * space,getHeight() / 2 ,radius,paint);
        }
        canvas.restore();
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setPosition(int position){
        this.position = position;

        invalidate();
    }
}
