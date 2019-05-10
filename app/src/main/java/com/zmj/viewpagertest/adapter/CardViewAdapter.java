package com.zmj.viewpagertest.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.entry.Work;
import com.zmj.viewpagertest.holder.CardViewHolder;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/9
 * Description :
 */
public class CardViewAdapter extends BaseQuickAdapter<Work,CardViewHolder> {

    public CardViewAdapter(int layoutResId, @Nullable List<Work> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(CardViewHolder helper, Work item) {
        Glide.with(mContext).load(R.drawable.share_item).into((ImageView) helper.getView(R.id.iv_firstPic));
        helper.setText(R.id.tv_description,item.getDescription());
        helper.setText(R.id.tv_userName,item.getAuthor().getNickName());
        //helper.setText(R.id.tv_collect,item.getCollectNum());

        //设置子控件的点击事件
        helper.addOnClickListener(R.id.tv_collect);
    }

    public void refreshData(List<Work> data){
        mData.clear();
        mData = data;
        notifyDataSetChanged();
    }

    public void addData(List<Work> data){
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
