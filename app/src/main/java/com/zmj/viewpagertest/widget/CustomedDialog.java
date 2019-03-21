package com.zmj.viewpagertest.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.zmj.viewpagertest.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/21
 * Description :自定义的弹出窗口
 *              弹出窗口，同时弹出软键盘
 */
public class CustomedDialog extends Dialog {

    private SearchView sv_tv;

    public CustomedDialog(@NonNull Context context) {
        super(context, R.style.MyDialogWithKeybord);//定义dialog样式
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customed_dialog_with_keybord_auto);

        sv_tv = findViewById(R.id.sv_tv);
    }
}
