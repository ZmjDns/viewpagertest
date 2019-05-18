package com.zmj.viewpagertest.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.entry.Work;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/10
 * Description : ShareFragment界面作品适配器
 */
public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkHolder> {

    private Context context;
    private List<Work> workList;
    private LayoutInflater inflater;
    private RequestOptions options;

    public WorkAdapter(Context context, List<Work> workList) {
        this.context = context;
        this.workList = workList;
        this.inflater = LayoutInflater.from(context);
        this.options = new RequestOptions().circleCrop();
    }

    @NonNull
    @Override
    public WorkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View view = inflater.inflate(R.layout.recycler_work_item,viewGroup,false);
        View view = inflater.inflate(R.layout.recycler_card_view,viewGroup,false);
        WorkHolder holder = new WorkHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkHolder holder, int position) {
        final Work work = workList.get(position);
        Glide.with(context).load(R.drawable.share_item).into(holder.iv_firstPic);
        holder.tv_description.setText(work.getDescription());
        Glide.with(context).load(R.drawable.share_head).apply(options).into(holder.iv_userHead);
        holder.tv_userName.setText(work.getAuthor().getNickName());
        holder.tv_collectNum.setText(work.getCollectNum());

        holder.iv_firstPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(work);
            }
        });

        holder.tv_collectNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(v,work);
            }
        });
    }

    @Override
    public int getItemCount(){
        return workList.size();
    }

    public void setWorkList(List<Work> workList){
        this.workList = workList;
        notifyDataSetChanged();
    }

    class WorkHolder extends RecyclerView.ViewHolder{
        CardView cv_card;
        ImageView iv_firstPic,iv_userHead;
        TextView tv_description,tv_userName,tv_collectNum;
        public WorkHolder(@NonNull View itemView) {
            super(itemView);
            cv_card = itemView.findViewById(R.id.cv_card);
            iv_firstPic = itemView.findViewById(R.id.iv_firstPic);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_collectNum = itemView.findViewById(R.id.tv_collectNum);
            iv_userHead = itemView.findViewById(R.id.iv_userHead);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Work work);
        void onItemClick(View view, Work work);
    }
    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
