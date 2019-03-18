package com.zmj.viewpagertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmj.viewpagertest.weakref.MyHandler;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/10
 * Description :启动引导界面,解决启动app短暂白屏问题
 * 测试Handler对Context的弱引用
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_act);

        startActivity(new Intent(this,MainActivity.class));

        finish();


        WeakHandler weakHandler = new WeakHandler(this);
        weakHandler.sendEmptyMessage(1);

    }


    /**
     * Handler持有Context的弱引用
     */
    class WeakHandler extends MyHandler<SplashActivity>{


        public WeakHandler(SplashActivity view) {
            super(view);
        }

        @Override
        protected void handleMessage(Context context, Message msg) {
            switch (msg.what){
                case 1:
                    //情况处理

                    break;
            }
        }
    }
}
