package com.zmj.viewpagertest.smartrefreshlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.adapter.CardViewAdapter;
import com.zmj.viewpagertest.entry.User;
import com.zmj.viewpagertest.entry.Work;
import com.zmj.viewpagertest.net.RetrofitSingleton;
import com.zmj.viewpagertest.utils.WidgetUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/9
 * Description :
 */
public class SmartLayoutAct extends AppCompatActivity {

    private SmartRefreshLayout srl_refresh;
    private RecyclerView rv_cardRV;

    private CardViewAdapter cardViewAdapter;
    private List<Work> workList = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_smart_refresh_layout);

        srl_refresh = findViewById(R.id.srl_refresh);
        rv_cardRV = findViewById(R.id.rv_cardRV);
        initNewWorkList();
        cardViewAdapter = new CardViewAdapter(R.layout.recycler_card_view_item,workList);
        gridLayoutManager = new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        rv_cardRV.setLayoutManager(gridLayoutManager);
        rv_cardRV.setAdapter(cardViewAdapter);

        initSRL();
    }

    private void initSRL(){



        srl_refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {

                Call<List<Work>> call = RetrofitSingleton.getMyRetrofit().apiService.getWorks();
                call.enqueue(new Callback<List<Work>>() {
                    @Override
                    public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {
                       if (response.body().size() > 0){
                           cardViewAdapter.refreshData(response.body());
                           WidgetUtil.showToast(SmartLayoutAct.this,"刷新");
                           refreshLayout.finishRefresh();
                       }
                    }

                    @Override
                    public void onFailure(Call<List<Work>> call, Throwable t) {
                        WidgetUtil.showToast(SmartLayoutAct.this,"刷新失败");
                        Log.d("刷新失败", "onFailure: 刷新失败:" + t.getMessage());
                    }
                });
            }
        });

        srl_refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                Call<List<Work>> call = RetrofitSingleton.getMyRetrofit().apiService.getWorks();
                call.enqueue(new Callback<List<Work>>() {
                    @Override
                    public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {
                        if (response.body().size() > 0){
                            cardViewAdapter.addData(response.body());
                            WidgetUtil.showToast(SmartLayoutAct.this,"加载");
                            refreshLayout.finishLoadMore();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Work>> call, Throwable t) {
                        WidgetUtil.showToast(SmartLayoutAct.this,"加载失败");
                        Log.d("加载失败", "onFailure: 加载失败:" + t.getMessage());
                    }
                });

            }
        });
    }

    private void initNewWorkList() {
        workList.clear();
        //String workUniqueId, User author, String description, Date time, List<String> picLists,String collectNum
        workList.add(new Work("123546651",new User("18302451881","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"文物简介  湖额度发改委的把手从很骄傲被我黑雾部分你对我好对啊死哦夏松代号为u文物简介  湖额度发改委的把手从很骄傲被我黑雾部分你对我好对啊死哦夏松代号为u文物简介  湖额度发改委的把手从很骄傲被我黑雾部分你对我好对啊死哦夏松代号为u文物简介  湖额度发改委的把手从很骄傲被我黑雾部分你对我好对啊死哦夏松代号为u文物简介  湖额度发改委的把手从很骄傲被我黑雾部分你对我好对啊死哦夏松代号为u",null,"50"));
        workList.add(new Work("123546652",new User("18302451882","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"description2",null,"50"));
        workList.add(new Work("123546653",new User("18302451883","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"description3",null,"50"));
        workList.add(new Work("123546654",new User("18302451884","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"description4",null,"50"));
        workList.add(new Work("123546655",new User("18302451885","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"description5",null,"50"));
        workList.add(new Work("123546656",new User("18302451886","我的昵称","https://www.baidu.com/img/bd_logo1.png"),"description6",null,"50"));
    }

}
