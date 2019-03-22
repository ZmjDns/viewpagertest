package com.zmj.viewpagertest.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/22
 * Description :
 */
public class User implements Parcelable {

    private String name;
    private String nickName;
    private int age;
    private String sex;
    private String brief;

    public User() {
    }

    public User(String name, String nickName, int age, String sex, String brief) {
        this.name = name;
        this.nickName = nickName;
        this.age = age;
        this.sex = sex;
        this.brief = brief;
    }

    protected User(Parcel in) {
        name = in.readString();
        nickName = in.readString();
        age = in.readInt();
        sex = in.readString();
        brief = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nickName);
        dest.writeInt(age);
        dest.writeString(sex);
        dest.writeString(brief);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
