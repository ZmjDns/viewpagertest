package com.zmj.viewpagertest.verticalviewpager;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.widget.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class TestVerticalViewPagerOneAct extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private List<String> urlList = new ArrayList<>();

    //private SwipeRefreshLayout srl_refresh;
    private VerticalViewPager vp_vViewPager;
//    private VViewPagerAdapter vViewPagerAdapter;
//    private VViewPagerAdapterNew vViewPagerAdapterNew;
    private VStatePagerAdapter vStatePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager_one);
        loadData();
        initVerticalViewPager();
    }

    private void initVerticalViewPager(){
        //srl_refresh = findViewById(R.id.srl_refresh);
        vp_vViewPager = findViewById(R.id.vp_vViewPager);
//        vViewPagerAdapter = new VViewPagerAdapter(getSupportFragmentManager(),urlList);
//        vp_vViewPager.setAdapter(vViewPagerAdapter);
        /*vViewPagerAdapterNew = new VViewPagerAdapterNew(getSupportFragmentManager(),this,urlList);
        vp_vViewPager.setAdapter(vViewPagerAdapterNew);*/
        vStatePagerAdapter = new VStatePagerAdapter(getSupportFragmentManager(),this,urlList);
        vp_vViewPager.setAdapter(vStatePagerAdapter);

        vp_vViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {
                Log.d(TAG, "onPageScrolled: ");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: 当前位置：" + position);

                if (position >= urlList.size() - 2){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadMoreData();
                        }
                    }).start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //下拉刷新
        final Handler handler = new Handler(Looper.getMainLooper());
        /*srl_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl_refresh.setRefreshing(false);
                    }
                },100);
            }
        });*/
    }

    private void loadData(){
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_1.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_2.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_3.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_4.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_5.jpg");
    }

    private void loadMoreData(){
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_6.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_7.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_8.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_9.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_10.jpg");

//        vViewPagerAdapter.setUrlList(urlList);
//        vViewPagerAdapter.notifyDataSetChanged();
        /*vViewPagerAdapterNew.setUrlList(urlList);
        vViewPagerAdapterNew.notifyDataSetChanged();*/
        vStatePagerAdapter.setUrlList(urlList);
        vStatePagerAdapter.notifyDataSetChanged();
    }


    protected void refreshData(){
        urlList.clear();
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_10.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_9.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_8.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_7.jpg");
        urlList.add("http://192.168.1.254:8080/corvertSXWWData/pics/view_6.jpg");

        vStatePagerAdapter.setUrlList(urlList);
        vStatePagerAdapter.notifyDataSetChanged();
    }

}
