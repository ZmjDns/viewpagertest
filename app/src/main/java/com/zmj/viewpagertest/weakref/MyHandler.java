package com.zmj.viewpagertest.weakref;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/18
 * Description :Handler持有Context的弱引用
 */
public abstract class MyHandler<T> extends Handler {

    private WeakReference<T> target;

    public MyHandler(T view) {
        this.target = new WeakReference<>(view);
    }

    @Override
    public void handleMessage(Message msg) {
        Context myTarget = (Context) target.get();
        if (myTarget != null){
            this.handleMessage(myTarget,msg);
        }
    }

    protected abstract void handleMessage(Context context,Message msg);

}
