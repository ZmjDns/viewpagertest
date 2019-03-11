package com.zmj.viewpagertest.aes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zmj.viewpagertest.R;
import com.zmj.viewpagertest.utils.AesHelper;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/11
 * Description :
 */
public class TestAesAct extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    private EditText ed_ming_wen1,ed_ming_wen2;

    private TextView tv_mi_wen1,tv_mi_wen2,tv_jie_mi1,tv_jie_mi2;

    private String password = "SANXIWENWUCLIENT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aes_test_act);


        ed_ming_wen1 = findViewById(R.id.ed_ming_wen1);
        ed_ming_wen2 = findViewById(R.id.ed_ming_wen2);

        tv_mi_wen1 = findViewById(R.id.tv_mi_wen1);
        tv_mi_wen2 = findViewById(R.id.tv_mi_wen2);
        tv_jie_mi2 = findViewById(R.id.tv_jie_mi2);
        tv_jie_mi1 = findViewById(R.id.tv_jie_mi1);
    }


    /**
     * 加密1
     * @param view
     */
    public void encryptAA(View view){
        String content = ed_ming_wen1.getText().toString();
        try {
            byte[] miByte = AesHelper.encrypt(content,password);
            String miString = new String(miByte,"utf-8");
            tv_mi_wen1.setText(miString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密2
     * @param view
     */
    public void encryptBB(View view){
        String content = ed_ming_wen2.getText().toString();
        try {
            byte[] miByte = AesHelper.encrypt(content,password);
            String miString = new String(miByte,"utf-8");
            tv_mi_wen2.setText(miString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptAA(View view){
        String miwen1 = tv_mi_wen1.getText().toString();
        byte[] miwen1byte = miwen1.getBytes();

        try {
            byte[] jiem1 = AesHelper.decrypt(miwen1byte,password);
            String jiemi1 = new String(jiem1,"utf-8");

            tv_jie_mi1.setText(jiemi1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptBB(View view){
        String miwen1 = tv_mi_wen2.getText().toString();
        byte[] miwen1byte = miwen1.getBytes();

        try {
            byte[] jiem1 = AesHelper.decrypt(miwen1byte,password);
            String jiemi1 = new String(jiem1,"utf-8");

            tv_jie_mi2.setText(jiemi1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
