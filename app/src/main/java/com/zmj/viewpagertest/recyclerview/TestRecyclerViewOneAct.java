package com.zmj.viewpagertest.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zmj.viewpagertest.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestRecyclerViewOneAct extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_view;
    private List<String> mData;

    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view_one);

        srl_refresh = findViewById(R.id.srl_refresh);
        rv_view = findViewById(R.id.rv_view);

        initData();

        initRecycler();

        initListener();
    }

    private void initRecycler(){
        recyclerAdapter = new RecyclerAdapter(this,mData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_view.setLayoutManager(staggeredGridLayoutManager);
        rv_view.setAdapter(recyclerAdapter);
    }

    private void initListener(){
        srl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                mData.clear();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mData.add("我是下拉刷新的数据1");
                        mData.add("我是下拉刷新的数据2");
                        mData.add("我是下拉刷新的数据3");
                        mData.add("我是下拉刷新的数据4");
                        mData.add("我是下拉刷新的数据5");
                        mData.add("我是下拉刷新的数据6");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerAdapter.setData(mData);
                                recyclerAdapter.notifyDataSetChanged();
                                srl_refresh.finishRefresh();
                            }
                        });
                    }
                }).start();

            }
        });

        srl_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mData.add("我是上拉加载的数据1");
                        mData.add("我是上拉加载的数据2");
                        mData.add("我是上拉加载的数据3");
                        mData.add("我是上拉加载的数据4");
                        mData.add("我是上拉加载的数据5");
                        mData.add("我是上拉加载的数据6");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerAdapter.setData(mData);
                                recyclerAdapter.notifyDataSetChanged();
                                srl_refresh.finishLoadMore();
                            }
                        });
                    }
                }).start();
            }
        });
    }








    private void initData(){
        mData = new ArrayList<>();
        mData.add("11111111111");
        mData.add("222222222");
        mData.add("33333333333");
        mData.add("4444444444444");
        mData.add("555555555");
        mData.add("666666666666");
        mData.add("777777777777");
        mData.add("88888888");
        mData.add("99");
        mData.add("10");
        mData.add("121212122");
    }

}
