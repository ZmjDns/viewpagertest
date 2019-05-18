package com.zmj.viewpagertest.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.utils.ScreenUtil;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/17
 * Description :
 */
public class PicBrowserAdapter extends RecyclerView.Adapter<PicBrowserAdapter.PicHolder> {

    private Context context;
    private List<String> urls;
    private LayoutInflater inflater;

    private int[] screenSize;

    public PicBrowserAdapter(Context context, List<String> urls) {
        this.context = context;
        this.urls = urls;
        this.inflater = LayoutInflater.from(context);
        this.screenSize = ScreenUtil.getScreenInfo(context);
    }

    @NonNull
    @Override
    public PicHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_author_work_pic_item,viewGroup,false);
        PicHolder picHolder = new PicHolder(view);
        return picHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PicHolder picHolder, int position) {

        RequestOptions options = new RequestOptions().override(screenSize[0],screenSize[1] * 2 / 3).centerCrop();

        Glide.with(context).load(urls.get(position)).apply(options).into(picHolder.iv_bigPic);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class PicHolder extends RecyclerView.ViewHolder{
        ImageView iv_bigPic;
        public PicHolder(@NonNull View itemView) {
            super(itemView);
            iv_bigPic = itemView.findViewById(R.id.iv_bigPic);
        }
    }
}
