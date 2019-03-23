package com.zmj.viewpagertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zmj.viewpagertest.aes.TestAesAct;
import com.zmj.viewpagertest.horizontalviewpager.TestHorizontalViewPagerOneAct;
import com.zmj.viewpagertest.parcelable.ParcelableUserList;
import com.zmj.viewpagertest.parcelable.ReverceParcelableAct;
import com.zmj.viewpagertest.parcelable.User;
import com.zmj.viewpagertest.recyclerview.TestRecyclerViewOneAct;
import com.zmj.viewpagertest.selfdefinview.MySelfDefinedViewAct;
import com.zmj.viewpagertest.verticalviewpager.TestVerticalViewPagerOneAct;
import com.zmj.viewpagertest.widget.CustomedDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_img = findViewById(R.id.iv_img);

        //Glide.with(this).load("http://192.168.1.254:8080/corvertSXWWData/pics/view_6.jpg").placeholder(R.drawable.palceholder).into(iv_img);
        //Picasso.with(this).load("http://192.168.1.254:8080/corvertSXWWData/pics/view_6.jpg").placeholder(R.drawable.palceholder).into(iv_img);
    }

    public void horizViewPager(View view){
        startActivity(new Intent(this, TestHorizontalViewPagerOneAct.class));
    }

    public void vertiaclViewPager(View view){
        startActivity(new Intent(this, TestVerticalViewPagerOneAct.class));
    }
    public void recyclerView(View view){
        startActivity(new Intent(this, TestRecyclerViewOneAct.class));
    }

    public void letAes(View view){
        startActivity(new Intent(this, TestAesAct.class));
    }

    public void selfWidget(View view){
        startActivity(new Intent(this, MySelfDefinedViewAct.class));
    }
    public void customDialog(View view){
        CustomedDialog customedDialog = new CustomedDialog(this);
        customedDialog.show();
    }

    public void delieverData(View view){
        User user1 = new User("AAA","AAAA",18,"man","I am AAA");
        User user2 = new User("BBB","BBBB",19,"man","I am BBB");
        User user3 = new User("CCC","CCCC",20,"man","I am CCC");
        User user4 = new User("DDD","DDDD",21,"man","I am DDD");

        ParcelableUserList userList = new ParcelableUserList();
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        userList.setSize(4);
        userList.setUserList(list);

        Intent intent = new Intent(this, ReverceParcelableAct.class);
        intent.putExtra("userList",userList);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        //Glide.clear(iv_img);
        super.onDestroy();
    }
}
