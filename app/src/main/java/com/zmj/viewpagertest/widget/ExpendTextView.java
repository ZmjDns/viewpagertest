package com.zmj.viewpagertest.widget;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/17
 * Description :
 */
public class ExpendTextView extends AppCompatTextView {
    public ExpendTextView(Context context) {
        super(context,null);
    }

    public ExpendTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        limitTextViewString(this.getText().toString(),30,this,new OnClickListener(){
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    //设置信息
    public void setText(String text){
        limitTextViewString(text,60,this,null);
    }

    /**
     * 限制TextView显示的字符串，并添加loadMore的点击事件
     * @param textString            显示的内容
     * @param maxFirstShowCount     第一次显示的内容数量
     * @param onClickListener       点击监听事件
     */
    private void limitTextViewString(String textString, int maxFirstShowCount, final TextView textView, final OnClickListener onClickListener) {
        //计算处理花费的时间
        final long startTime = System.currentTimeMillis();
        if (textView == null)return;
        int width = textView.getWidth();
        if (width == 0) width = 1000;
        int lastCharIndex = getLastCharIndexFromLimitTextView(textView,textString,width,2);
        if (lastCharIndex < 0 && textString.length() <= maxFirstShowCount){
            //没有超过行数限制
            textView.setText(textString);
            return;
        }
        //超出了行数限制
        textView.setMovementMethod(LinkMovementMethod.getInstance());//this will deprive the recyclerView's focus
        if (lastCharIndex > maxFirstShowCount || lastCharIndex < 0){
            lastCharIndex = maxFirstShowCount;
        }
        //构造SpannableString
        String explicitText = null;
        String explicitTextAll;
        if (textString.charAt(lastCharIndex) == '\n'){
            explicitText = textString.substring(0,lastCharIndex);
        }else if (lastCharIndex > 12){
            //如果最大行数限制的那一行到达12以后则直接显示更多
            explicitText = textString.substring(0,lastCharIndex -12);
        }
        int sourceLength = explicitText.length();
        String showMore = "展开";
        explicitText = explicitText + "..." + showMore;
        final SpannableString mSpan = new SpannableString(explicitText);

        String dissmissMore = "收起";
        explicitTextAll = textString + "   " + dissmissMore;
        final  SpannableString mSpanAll = new SpannableString(explicitTextAll);

        mSpanAll.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(textView.getResources().getColor(android.R.color.background_dark));//dark
                ds.setTextSize(50);
                ds.setAntiAlias(true);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View widget) {
                textView.setText(mSpan);
                textView.setOnClickListener(null);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (onClickListener != null)
                            textView.setOnClickListener(onClickListener);//prevent the double click     阻止双击
                    }
                },20);
            }
        },textString.length(),explicitTextAll.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mSpan.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(textView.getResources().getColor(android.R.color.background_dark));//dark
                ds.setTextSize(50);
                ds.setAntiAlias(true);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View widget) {//"...show more" click event
                textView.setText(mSpanAll);
                textView.setOnClickListener(null);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (onClickListener != null)
                            textView.setOnClickListener(onClickListener);
                    }
                },20);

            }
        },sourceLength,explicitText.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(mSpan);

        Log.d("ExpendTextView", "limitTextViewString: 处理耗时：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * 返回最大行数限制的最后一个字符串的下标，如果没有达到限制返回  -1
     * @param textView
     * @param content
     * @param width
     * @param maxLine   限定的行数
     * @return      -1：没有到达限定的行数
     */
    private int getLastCharIndexFromLimitTextView(TextView textView, String content, int width, int maxLine) {
        TextPaint textPaint = textView.getPaint();
        StaticLayout staticLayout = new StaticLayout(content,textPaint,width, Layout.Alignment.ALIGN_NORMAL,1,0,false);
        if (staticLayout.getLineCount() > maxLine){
            return staticLayout.getLineStart(maxLine) - 1;
        }else {
            return -1;
        }
    }
}
