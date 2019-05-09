package com.zmj.viewpagertest.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.widget.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/9
 * Description :
 */
public class TestRvBannerAct extends AppCompatActivity {

    private com.loonggg.rvbanner.lib.RecyclerViewBanner ts_rvBanner;

    private ConvenientBanner cb_rvBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_banner);

        ts_rvBanner = findViewById(R.id.ts_rvBanner);

        cb_rvBanner = findViewById(R.id.cb_rvBanner);

        final List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("http://123.206.55.106:8088/SXWWServer/images/yungangshiku.jpg"));
        banners.add(new Banner("http://123.206.55.106:8088/SXWWServer/images/wutaishan.jpg"));
        banners.add(new Banner("http://123.206.55.106:8088/SXWWServer/images/pingyaogucheng.jpg"));
        banners.add(new Banner("http://123.206.55.106:8088/SXWWServer/images/chengqiang.jpg"));
        banners.add(new Banner("http://123.206.55.106:8088/SXWWServer/images/pingyaogucheng.jpg"));

        ts_rvBanner.setRvBannerData(banners);

        ts_rvBanner.setOnSwitchRvBannerListener(new com.loonggg.rvbanner.lib.RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int i, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext()).load(banners.get(i).getUrl()).into(bannerView);
            }
        });

        List<String> urls = new ArrayList<>();
        urls.add("http://123.206.55.106:8088/SXWWServer/images/yungangshiku.jpg");
        urls.add("http://123.206.55.106:8088/SXWWServer/images/wutaishan.jpg");
        urls.add("http://123.206.55.106:8088/SXWWServer/images/pingyaogucheng.jpg");
        urls.add("http://123.206.55.106:8088/SXWWServer/images/chengqiang.jpg");

        initBanner(urls);
    }

    private class Banner {

        String url;

        public Banner(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    private void initBanner(List<String> banners) {
        if (banners != null && banners.size() > 0) {
            cb_rvBanner.setPages(new CBViewHolderCreator() {
                @Override
                public Holder createHolder(View itemView) {
                    return new LocalImageHolderView(itemView);
                }

                @Override
                public int getLayoutId() {
                    //加载哪一个布局
                    return R.layout.recycler_author_work_pic_item;
                }
            }, banners)
            .setPageIndicator(new int[] {R.drawable.collection,R.drawable.collection_null})
            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
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
            Glide.with(TestRvBannerAct.this).load(data).into(imageView);
        }
    }
}
