package com.zmj.viewpagertest.selfdefinview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

import com.zmj.viewpagertest.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/18
 * Description :一些自定义的控件
 */
public class MySelfDefinedViewAct extends AppCompatActivity {

    /**
     * 1.drawable中编写layer-list文件（rating.xml）
     * 2.style中定义自己的样式  （MyRatingBar）
     * 3.在布局中引用RaringBar控件，style引用MyRatingBar
     *
     * 一定要注意  切图的形象图片，五角星不能顶到边，否则出现条形线
     * 自定义背景图片下面有直线是因为图片上的五角星顶到边了
     */
    private RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_self_defined_view_act);

    }
}
