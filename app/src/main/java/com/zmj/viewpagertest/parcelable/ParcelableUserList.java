package com.zmj.viewpagertest.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/3/23
 * Description :
 */
public class ParcelableUserList implements Parcelable {

    private int size;
    private List<User> userList;

    public ParcelableUserList() {
    }

    protected ParcelableUserList(Parcel in) {
        //this.userList = new ArrayList<>();
        size = in.readInt();
        //in.readTypedList(userList,User.CREATOR);
        userList = in.createTypedArrayList(User.CREATOR);
    }

    public static final Creator<ParcelableUserList> CREATOR = new Creator<ParcelableUserList>() {
        @Override
        public ParcelableUserList createFromParcel(Parcel in) {
            return new ParcelableUserList(in);
        }

        @Override
        public ParcelableUserList[] newArray(int size) {
            return new ParcelableUserList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(size);
        dest.writeTypedList(userList);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
