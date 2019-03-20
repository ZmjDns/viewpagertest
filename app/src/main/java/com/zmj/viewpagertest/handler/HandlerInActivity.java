package com.zmj.viewpagertest.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zmj.viewpagertest.weakref.MyHandler;

import retrofit2.Retrofit;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/13
 * Description :
 */
public class HandlerInActivity extends AppCompatActivity {

    WeakRefHandler weakRefHandler;
    WorkThread workThread;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        weakRefHandler = new WeakRefHandler(this);

        workThread = new WorkThread();
        workThread.start();


    }

    private class WorkThread extends Thread{
        @Override
        public void run() {
            super.run();
            //耗时操作

            //****

            //从全局池中返回一个message实例，避免多次创建（如new Message（））
            Message msg = Message.obtain();
            msg.obj = "aaa";
            msg.what = 1;
            weakRefHandler.sendMessage(msg);

        }
    }



    /**
     * 为避免内存泄漏，使用内部静态类，对外部类不保持对象引用
     * 但handler需要与Activity通信，所以需要增加一个对Activity的弱引用
     */
    private static class WeakRefHandler extends MyHandler<HandlerInActivity>{

        public WeakRefHandler(HandlerInActivity view) {
            super(view);
        }

        @Override
        protected void handleMessage(Context context, Message msg) {
            switch (msg.what){
                //判断情况，进行UI操作
                case 1:
                    Toast.makeText(context,"UI线程中获取的Msg" + msg.obj.toString(),Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        //避免Activity销毁时，MessageQueue中的消息未处理完，故此时应把对应的message清出队列
        weakRefHandler.removeCallbacks(workThread);//清除runnable对应的message
        weakRefHandler.removeMessages(1);    //清除what对应的message
        //workThread  和 msg.what可以在使用后回收
        super.onDestroy();
    }

    //子线程中使用Handler的方法
    //https://blog.csdn.net/fnhfire_7030/article/details/79518819
    class LooperThread extends Thread{
        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    //
                }
            };
            Looper.loop();
        }
    }
}
