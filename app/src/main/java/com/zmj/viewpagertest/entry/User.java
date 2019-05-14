package com.zmj.viewpagertest.entry;

import java.io.Serializable;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/12
 * Description :
 */
public class User implements Serializable {
    private String phoneNum;
    private String nickName;
    private String headLink;

    public User() {
    }

    public User(String phoneNum, String nickName, String headLink) {
        this.phoneNum = phoneNum;
        this.nickName = nickName;
        this.headLink = headLink;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadLink() {
        return headLink;
    }

    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }
}
