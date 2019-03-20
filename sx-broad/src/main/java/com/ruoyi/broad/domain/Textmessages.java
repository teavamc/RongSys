package com.ruoyi.broad.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @program: dyq_RongSys
 * @description: 短信表
 * @author: 戴誉琪
 * @create: 2019-01-14 15:25
 **/
public class Textmessages extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**电话id*/
    private String telid;
    /**终端id*/
    private String tid;
    /** 电话号码*/
    private String tel;
    /** 电话号码所属人*/
    private String telpersion;
    /** 是否可用*/
    private int isuse;


    @Override
    public String toString() {
        return "Textmessages{" +
                "telid='" + telid + '\'' +
                ", tid='" + tid + '\'' +
                ", tel='" + tel + '\'' +
                ", telpersion='" + telpersion + '\'' +
                ", isuse=" + isuse +
                '}';
    }

    public Textmessages(String telid, String tid, String tel,
                        String telpersion,
                        int isuse) {
        this.telid = telid;
        this.tid = tid;
        this.tel = tel;
        this.telpersion = telpersion;
        this.isuse = isuse;
    }

    public Textmessages() {
        super();
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTelid() {
        return telid;
    }

    public void setTelid(String telid) {
        this.telid = telid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelpersion() {
        return telpersion;
    }

    public void setTelpersion(String telpersion) {
        this.telpersion = telpersion;
    }

    public int getIsuse() {
        return isuse;
    }

    public void setIsuse(int isuse) {
        this.isuse = isuse;
    }
}
