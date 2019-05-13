package com.zmj.viewpagertest.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/13
 * Description :
 */
public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {
    private int itemSpace;
    private int itemNum;

    /**
     * @param itemSpace item间隔
     * @param itemNum   每行item的个数
     */
    public RecyclerItemDecoration(int itemSpace, int itemNum) {
        this.itemSpace = itemSpace;
        this.itemNum = itemNum;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = itemSpace*2;

        //parent.getChildLayoutPosition(view) 获取view的下标
        if (parent.getChildLayoutPosition(view) % itemNum == 0) {
            outRect.left = 0;
            if (itemNum == 1 || itemNum == 3) {
                outRect.right = 0;
            } else {
                outRect.right = itemSpace;
            }
        } else {
            outRect.left = itemSpace;
            outRect.right = 0;
        }
    }
}
