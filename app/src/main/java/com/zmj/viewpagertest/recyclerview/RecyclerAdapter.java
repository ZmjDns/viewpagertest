package com.zmj.viewpagertest.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zmj.viewpagertest.R;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/2/27
 * Description :
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private LayoutInflater inflater;
    private List<String> mData;

    private boolean isLike = false;

    public RecyclerAdapter(Context mContext,List<String> mData) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_card_item,viewGroup,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int position) {
        Picasso.with(mContext).load("http://192.168.1.254:8080/corvertSXWWData/pics/view_1.jpg").placeholder(R.drawable.palceholder).into(myHolder.iv_firstPic);
        Picasso.with(mContext).load("http://192.168.1.254:8080/corvertSXWWData/pics/view_2.jpg").placeholder(R.drawable.palceholder).into(myHolder.iv_userHeader);
        myHolder.tv_title.setText(R.string.titleStrings + mData.get(position));
        myHolder.tv_userName.setText(R.string.userName);
        myHolder.tv_collection.setText("12");

        myHolder.tv_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int like = Integer.parseInt(myHolder.tv_collection.getText().toString());
                if (!isLike){
                    like++;
                    isLike = true;
                }else{
                    like--;
                    isLike = false;
                }
                myHolder.tv_collection.setText(String.valueOf(like));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<String> mData){
        this.mData = mData;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv_firstPic,iv_userHeader;
        TextView tv_title,tv_userName,tv_collection;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            iv_firstPic = itemView.findViewById(R.id.iv_firstPic);
            iv_userHeader = itemView.findViewById(R.id.iv_userHeader);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_collection = itemView.findViewById(R.id.tv_collection);
        }
    }
}
