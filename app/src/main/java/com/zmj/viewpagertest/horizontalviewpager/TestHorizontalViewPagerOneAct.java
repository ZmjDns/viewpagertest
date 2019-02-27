package com.zmj.viewpagertest.horizontalviewpager;

import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zmj.viewpagertest.R;

public class TestHorizontalViewPagerOneAct extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private String[] TITLES = {"国学","数学","英语","化学"};

    private SwipeRefreshLayout srl_swipeRefLayout;
    private TabLayout tab_layout;
    private ViewPager vp_hViewPager;

    private HViewPagerAdapter hViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_horizontal_view_pager_one);

        srl_swipeRefLayout = findViewById(R.id.srl_swipeRefLayout);
        tab_layout = findViewById(R.id.tab_layout);
        vp_hViewPager = findViewById(R.id.vp_hViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initViews();
    }

    private void initViews() {
        hViewPagerAdapter = new HViewPagerAdapter(getSupportFragmentManager(),TITLES);
        vp_hViewPager.setAdapter(hViewPagerAdapter);
        vp_hViewPager.setCurrentItem(0);
        vp_hViewPager.setOffscreenPageLimit(TITLES.length - 1);

        //将ViewPager放到TabLayout中
        tab_layout.setupWithViewPager(vp_hViewPager);

        //下拉刷新
        /*final Handler handler = new Handler(Looper.getMainLooper());
        srl_swipeRefLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl_swipeRefLayout.setRefreshing(false);
                    }
                },100);
            }
        });*/

        //ViewPager监听
        vp_hViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: 当前位置：" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadData(){
        String[] titles = {"国学1","数学1","英语1","化学1"};
        hViewPagerAdapter.setTitles(titles);
    }

}
