package com.zmj.viewpagertest.verticalviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.fragment.BaseLazyFragment;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/2/26
 * Description :
 */
public class PicFragment extends BaseLazyFragment {
    private final String TAG = this.getClass().getSimpleName();

    private String mUrl;
    private boolean isShowCommitmentArea = false;

    //private Context mContext;
    private ImageView iv_pic;
    private TextView tv_collect,tv_commitment,tv_share,tv_allCommitmentArea;
    private LinearLayout ll_commitmentArea;
    private ExpandableListView el_expList;

    public static PicFragment getPicFragment(String url){
        PicFragment fragment = new PicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("URLINFO",url);
        fragment.setArguments(bundle);

        return fragment;
    }

    /*public void setContext(Context context){
        if (mContext != null){
            return;
        }
        this.mContext = context;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrl = getArguments().getString("URLINFO");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pic_fragment_layout,container,false);
        iv_pic = view.findViewById(R.id.iv_pic);
        tv_collect = view.findViewById(R.id.tv_collect);
        tv_commitment = view.findViewById(R.id.tv_commitment);
        tv_share = view.findViewById(R.id.tv_share);
        ll_commitmentArea = view.findViewById(R.id.ll_commitmentArea);
        tv_allCommitmentArea = view.findViewById(R.id.tv_allCommitmentArea);
        el_expList = view.findViewById(R.id.el_expList);
        //Glide.with(container.getContext()).load(mUrl).placeholder(R.drawable.palceholder).into(iv_pic);
        Picasso.with(container.getContext())
                .load(mUrl)
                .placeholder(R.drawable.palceholder)
                .into(iv_pic);
        initListener();
        return view;
    }

    @Override
    protected void lazyLoad() {
//        if (!mIsprepared || !mIsVisible || mHasLoadedOnce){
//            return;
//        }
    }

    private void initListener(){
        tv_commitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowCommitmentArea){
                    ll_commitmentArea.setVisibility(View.VISIBLE);
                    isShowCommitmentArea = true;
                }else {
                    ll_commitmentArea.setVisibility(View.GONE);
                    isShowCommitmentArea = false;
                }
            }
        });

        //Glide.with(mContext).load(mUrl).placeholder(R.drawable.palceholder).into(iv_pic);
    }

    @Override
    public void onDestroy() {
        //Glide.clear(iv_pic);
        //mContext = null;
        super.onDestroy();
    }
}
