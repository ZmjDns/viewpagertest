package com.zmj.viewpagertest.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/4/10
 * Description :
 */
public class Work implements Serializable {
    private String workUniqueId;
    private User author;
    private String description;
    private Date time;
    private List<String> picLists;
    private String collectNum;

    public Work() {
    }

    public Work(String workUniqueId, User author, String description, List<String> picLists,String collectNum) {
        this.workUniqueId = workUniqueId;
        this.author = author;
        this.description = description;
        this.time = new Date();
        this.picLists = picLists;
        this.collectNum = collectNum;
    }

    public String getWorkUniqueId() {
        return workUniqueId;
    }

    public void setWorkUniqueId(String workUniqueId) {
        this.workUniqueId = workUniqueId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getPicLists() {
        return picLists;
    }

    public void setPicLists(List<String> picLists) {
        this.picLists = picLists;
    }

    public String getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(String collectNum) {
        this.collectNum = collectNum;
    }
}
