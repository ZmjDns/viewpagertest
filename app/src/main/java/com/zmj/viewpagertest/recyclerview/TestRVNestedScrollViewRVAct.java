package com.zmj.viewpagertest.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.entry.User;
import com.zmj.viewpagertest.entry.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/8
 * Description :RecyclerView中内嵌NestedScrollView，NestedScrollView中内嵌RecyclerView
 */
public class TestRVNestedScrollViewRVAct extends AppCompatActivity {

    private RecyclerView rv_root;

    private WorksAdapter worksAdapter;
    private List<Work> workList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_nestedscroll_rv);

        rv_root = findViewById(R.id.rv_root);

        initWorkData();

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_root.setLayoutManager(manager);
        worksAdapter = new WorksAdapter(this,workList);
        rv_root.setAdapter(worksAdapter);
    }

    private void initWorkData() {
        List<String> picLists = new ArrayList<>();

        picLists.add("http://123.206.55.106:8088/SXWWServer/images/yungangshiku.jpg");
        picLists.add("http://123.206.55.106:8088/SXWWServer/images/wutaishan.jpg");
        picLists.add("http://123.206.55.106:8088/SXWWServer/images/pingyaogucheng.jpg");
        picLists.add("http://123.206.55.106:8088/SXWWServer/images/chengqiang.jpg");

        workList.add(new Work("123546651",new User("18302451881","我的昵称新1","https://www.baidu.com/img/bd_logo1.png"),"description11https://www.baidu.com/img/bd_logo1.pnghttps://www.baidu.com/img/bd_logo1.pnghttps://www.baidu.com/img/bd_logo1.pnghttps://www.baidu.com/img/bd_logo1.pnghttps://www.baidu.com/img/bd_logo1.png",picLists,"50"));
        workList.add(new Work("123546652",new User("18302451882","我的昵称新2","https://www.baidu.com/img/bd_logo1.png"),"description22可以代表Activity,Fragment,Fragment，也可是Context等，我们可以看下这个函数的重载情况，with函数如果传入的是fragment或者activity，那么整个加载流程会与activity/fragment的生命周期绑定，比如onpause就会停止加载，onResumed的时候就重新加载。" ,picLists,"50"));
        workList.add(new Work("123546653",new User("18302451883","我的昵称新3","https://www.baidu.com/img/bd_logo1.png"),"description33那么整个加载流程会与activity/fragment的生命周期绑定，比如onpause就会停止加载，onResumed的时候就重新加载。",picLists,"50"));
        workList.add(new Work("123546654",new User("18302451884","我的昵称新4","https://www.baidu.com/img/bd_logo1.png"),"description44",picLists,"50"));
        workList.add(new Work("123546655",new User("18302451885","我的昵称新5","https://www.baidu.com/img/bd_logo1.png"),"description55",picLists,"50"));
        workList.add(new Work("123546656",new User("18302451886","我的昵称新6","https://www.baidu.com/img/bd_logo1.png"),"description66",picLists,"50"));
    }
}
