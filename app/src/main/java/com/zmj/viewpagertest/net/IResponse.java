package com.zmj.viewpagertest.net;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/5/9
 * Description :
 */
public interface IResponse<T> {
    void onSuccess(T response);
    void onFailed(Throwable throwable);
}
