package com.zmj.viewpagertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zmj.viewpagertest.horizontalviewpager.TestHorizontalViewPagerOneAct;
import com.zmj.viewpagertest.recyclerview.TestRecyclerViewOneAct;
import com.zmj.viewpagertest.verticalviewpager.TestVerticalViewPagerOneAct;

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

    @Override
    protected void onDestroy() {
        //Glide.clear(iv_img);
        super.onDestroy();
    }
}
