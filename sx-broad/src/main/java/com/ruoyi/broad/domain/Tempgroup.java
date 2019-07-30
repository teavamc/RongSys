package com.ruoyi.broad.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * Created by ASUS on 2019/7/29.
 * @author 陈霞
 */
public class Tempgroup extends BaseEntity {

    /*临时分组编号*/
    private int tgid;

    /*临时分组名称*/
    private String tgname;

    /*终端名称*/
    private String tname;

    /*建立人*/
    private String userid;

    /*使用权限人*/
    private String rightuname;

    /*创建时间*/
    private String createtime;

    /*这个字段数据库里没注释，暂时不知道其作用*/
    private String note;

    /*这个字段在数据库里是bit查询的时候要注意一下，表示是否启用*/
    private String isuse;

    /*设备IEME*/
    private String tid;

    /*所属分组id*/
    private String aid;

    /*区域名称*/
    private String aname;

    /*用户名*/
    private String uname;

    /*用户电话*/
    private String phone;

    /*终端地址*/
    private String address;


    public int getTgid() {
        return tgid;
    }

    public void setTgid(int tgid) {
        this.tgid = tgid;
    }

    public String getTgname() {
        return tgname;
    }

    public void setTgname(String tgname) {
        this.tgname = tgname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRightuname() {
        return rightuname;
    }

    public void setRightuname(String rightuname) {
        this.rightuname = rightuname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Tempgroup{" +
                "tgid=" + tgid +
                ", tgname='" + tgname + '\'' +
                ", tname='" + tname + '\'' +
                ", userid='" + userid + '\'' +
                ", rightuname='" + rightuname + '\'' +
                ", createtime='" + createtime + '\'' +
                ", note='" + note + '\'' +
                ", isuse='" + isuse + '\'' +
                ", tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
