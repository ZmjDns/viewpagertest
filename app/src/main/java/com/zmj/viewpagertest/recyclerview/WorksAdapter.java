package com.zmj.viewpagertest.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.entry.Work;
import com.zmj.viewpagertest.widget.BannerIndicator;
import com.zmj.viewpagertest.widget.ExpendTextView;
import com.zmj.viewpagertest.widget.RecyclerViewBanner;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/16
 * Description :分享详情界面所加载的所有分享适配器
 */
public class WorksAdapter extends RecyclerView.Adapter<WorksAdapter.SingleWorkHolder> {

    private Context context;
    private List<Work> workList;
    private LayoutInflater inflater;
    private RequestOptions options = new RequestOptions().circleCrop();

    public WorksAdapter(Context context, List<Work> workList) {
        this.context = context;
        this.workList = workList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SingleWorkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.work_item_detail,viewGroup,false);
        return new SingleWorkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SingleWorkHolder holder, int position) {
        final Work work = workList.get(position);

        if (work.getAuthor().getHeadLink() != null){
            Glide.with(context).load(work.getAuthor().getHeadLink()).apply(options).into(holder.iv_header);
        }
        List<String> urls = work.getPicLists();
        if (urls != null && urls.size() > 0){
            holder.rv_workPics.setPages(new CBViewHolderCreator() {
                @Override
                public Holder createHolder(View itemView) {
                    return new LocalImageHolderView(itemView);
                }

                @Override
                public int getLayoutId() {
                    return R.layout.recycler_author_work_pic_item;
                }
            },urls)
            .setPageIndicator(new int[]{R.drawable.collection_null,R.drawable.collection})
            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);


            /*final LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            holder.rv_workPics.setLayoutManager(manager);
            holder.rv_workPics.setAdapter(new PicBrowserAdapter(context,work.getPicLists()));

            holder.bi_picBanner.setNumber(work.getPicLists().size());

            //https://www.jianshu.com/p/e54db232df62        An instance of OnFlingListener already set
            PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
            holder.rv_workPics.setOnFlingListener(null);
            pagerSnapHelper.attachToRecyclerView(holder.rv_workPics);
            //holder.rv_workPics.setNestedScrollingEnabled(false);

            holder.rv_workPics.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    //super.onScrollStateChanged(recyclerView, newState);
                    if (newState == RecyclerView.SCROLL_STATE_IDLE){
                        int i = manager.findFirstVisibleItemPosition() % work.getPicLists().size();
                        holder.bi_picBanner.setPosition(i);
                    }
                }
            });*/
        }
        holder.tv_workDescription.setText("\t\t\t\t" + work.getDescription());
        holder.tv_authorNick.setText(work.getAuthor().getNickName());
        holder.tv_workCollect.setText(work.getCollectNum());

        holder.tv_workShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyUtils.openShareIntent(context,"发现一个好玩的应用,邀您一起来玩：http://www.baidu.com/");
            }
        });
        /*holder.tv_workCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先判断是不是自己的作品
                //自己的作品不能收藏。提示在我的作品里查看
                if (MyUtils.isMySelfWork(context,work.getAuthor().getPhoneNum())){
                    WidgetUtil.showToast(context,"自己的作品请在“我的作品”里查看");
                }else {
                    if (WidgetUtil.getCollectState(context,"shared",work.getWorkUniqueId())){
                        WidgetUtil.showToast(context,"您已经收藏过咯!");
                    }else {
                        //添加收藏
                        //uniqueId, type, name, address, brief,imageLink1
                        MyCollection myCollection = new MyCollection(work.getWorkUniqueId(),"shared",work.getAuthor().getNickName(),work.getAuthor().getPhoneNum(),work.getDescription(),MyUtils.convertImgLinkListToStr(work.getPicLists()));
                        WidgetUtil.addCollection(context,myCollection);
                        int num = Integer.parseInt(work.getCollectNum()) + 1;
                        holder.tv_workCollect.setText(String.valueOf(num));
                        WidgetUtil.showToast(context,"收藏成功");
                        //通知服务端


                    }
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }


    class SingleWorkHolder extends RecyclerView.ViewHolder{
        ImageView iv_header;
        TextView tv_authorNick,tv_workShare,tv_workCollect;
        ExpendTextView tv_workDescription;
        ConvenientBanner rv_workPics;
        BannerIndicator bi_picBanner;
        public SingleWorkHolder(@NonNull View itemView) {
            super(itemView);
            iv_header = itemView.findViewById(R.id.iv_header);
            tv_authorNick = itemView.findViewById(R.id.tv_authorNick);
            tv_workDescription = itemView.findViewById(R.id.tv_workDescription);
            tv_workShare = itemView.findViewById(R.id.tv_workShare);
            tv_workCollect = itemView.findViewById(R.id.tv_workCollect);
            rv_workPics = itemView.findViewById(R.id.rv_workPics);
            bi_picBanner = itemView.findViewById(R.id.bi_picBanner);
        }
    }


    public class LocalImageHolderView extends Holder<String>{
        private ImageView imageView;

        public LocalImageHolderView(View itemView) {
            super(itemView);
        }


        @Override
        protected void initView(View itemView) {
            imageView = itemView.findViewById(R.id.iv_bigPic);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }

        @Override
        public void updateUI(String data) {
            Log.d("AAAAA", "updateUI: data：" + data);
            Glide.with(context).load(data).into(imageView);
        }
    }
}
