package com.zmj.viewpagertest.advancedwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.utils.WidgetUtil;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/10
 * Description :
 */
public class AdvancedWidgetAct extends AppCompatActivity {

    private NestedScrollView ns_scroll;
    private Button snackBar;
    private FloatingActionButton btn_fab;

    private Toolbar toolBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_widget);

        ns_scroll = findViewById(R.id.ns_scroll);

        btn_fab = findViewById(R.id.btn_fab);

        toolBar = findViewById(R.id.toolBar);

        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolBar.setTitle("标题");
        toolBar.setSubtitle("子标题");
        toolBar.setNavigationIcon(R.drawable.collection);//可以用来显示侧边菜单栏
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

    }

    public void snackBar(View view){
        //view 是SnackBar在那个View上显示，（不能是ScrollView 因为ScrollView能滑动）
        Snackbar snackbar = Snackbar.make(ns_scroll,"jump SnackBar!",Snackbar.LENGTH_LONG);
        snackbar.show();
        snackbar.setAction("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WidgetUtil.showToast(AdvancedWidgetAct.this,"SnackBar Action");
            }
        });
        //覆盖上一个Action
        snackbar.setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WidgetUtil.showToast(AdvancedWidgetAct.this,"SnackBar Action Conform!");
            }
        });
    }

    public void floatingActionBtn(View view){
        WidgetUtil.showToast(this,"I am FloatingActionButton!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_collect:
                WidgetUtil.showToast(this,"收藏");
                break;
            case R.id.action_record:
                WidgetUtil.showToast(this,"记录");
                break;
            case R.id.action_delete:
                WidgetUtil.showToast(this,"删除");
                break;
            case R.id.action_find:
                WidgetUtil.showToast(this,"查找");
                break;
        }
        return true;
    }
}
