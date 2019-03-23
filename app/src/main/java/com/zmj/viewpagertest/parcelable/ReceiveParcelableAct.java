package com.zmj.viewpagertest.parcelable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zmj.viewpagertest.R;

import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/23
 * Description :
 */
public class ReceiveParcelableAct extends AppCompatActivity {

    private List<User> userList;
    private TextView tv_jie_mi1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aes_test_act);

        tv_jie_mi1 = findViewById(R.id.tv_jie_mi1);

        ParcelableUserList gotUserList = getIntent().getParcelableExtra("userList");
        userList = gotUserList.getUserList();

        initData();
    }

    private void initData(){
        String info = "";
        for (User user : userList){
            info += user.getName() + " " + user.getAge();
        }

        tv_jie_mi1.setText(info);
    }
}
