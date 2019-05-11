package com.zmj.viewpagertest.net;

import com.zmj.viewpagertest.config.Const;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/9
 * Description :
 */
public class RetrofitSingleton {
    public static RetrofitSingleton myRetrofit;
    public ApiService apiService;

    public static RetrofitSingleton getMyRetrofit() {
        if (myRetrofit == null){
            synchronized (RetrofitSingleton.class){
                if (myRetrofit == null){
                    myRetrofit = new RetrofitSingleton();
                }
            }
        }
        return myRetrofit;
    }

    private RetrofitSingleton() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }
}
