package com.ruoyi.broad.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * Created by ASUS on 2019/7/12.
 * @author 陈霞
 */
public class MaintainApply extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /* 维护编号*/
    private String maid;
    /*终端编号*/
    private String teraddress;
    /*联系人*/
    private String linkman;
    /*联系电话*/
    private String linkphone;
    /*故障时间*/
    private String downtime;
    /*备注*/
    private String applytime;
    /*维护时间*/
    private String status;
    /*用户id*/
    private Long userid;
    /*评论*/
    private String remark;
    /** 操作（所属）用户编号 */
    private Long uid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getMaid() {
        return maid;
    }

    public void setMaid(String maid) {
        this.maid = maid;
    }

    public String getTeraddress() {
        return teraddress;
    }

    public void setTeraddress(String teraddress) {
        this.teraddress = teraddress;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MaintainApply{" +
                "maid='" + maid + '\'' +
                ", teraddress='" + teraddress + '\'' +
                ", linkman='" + linkman + '\'' +
                ", linkphone='" + linkphone + '\'' +
                ", downtime='" + downtime + '\'' +
                ", applytime='" + applytime + '\'' +
                ", status='" + status + '\'' +
                ", userid='" + userid + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
