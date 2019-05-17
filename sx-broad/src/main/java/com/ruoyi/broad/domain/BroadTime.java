package com.ruoyi.broad.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author 周博
 * @Description: 根据时间和地区对广播数目的统计
 * @ClassName BroadTime
 * @date 2019/3/13
 */
public class BroadTime {

    /*广播时间*/
    private String broadDate;

    /*广播数量*/
    private String bcount;

    /*播出方式*/
    private String scategory;

    public String getScategory() {
        return scategory;
    }

    public void setScategory(String scategory) {
        this.scategory = scategory;
    }

    public String getBroadDate() {
        return broadDate;
    }

    public void setBroadDate(String broadDate) {
        this.broadDate = broadDate;
    }


    public String getBcount() {
        return bcount;
    }

    public void setBcount(String count) {
        this.bcount = count;
    }

    @Override
    public String toString() {
        return "BroadTime{" +
                "broadDate='" + broadDate + '\'' +
                ", bcount='" + bcount + '\'' +
                ", scategory='" + scategory + '\'' +
                '}';
    }
}
