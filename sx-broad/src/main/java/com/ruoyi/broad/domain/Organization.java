package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 终端表 tb_organization
 *
 * @author 张鸿权
 * @date 2019-02-17
 */
public class Organization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 终端设备IMEI */
    private String tid;
    /** 终端设备名称 */
    private String tname;
    /** 所属分组编号 */
    private String aid;
    /** 区域名称 */
    private String aname;
    /** 所属用户编号 */
    private String userid;
    /** 管理员姓名 */
    private String uname;
    /** 最后处理时间 */
    private String lastaccesstime;
    /** 出厂编号 */
    private String facid;
    /** 安装地址 */
    private String address;
    /** 备注 */
    private String note;
    /** 终端接入通信网 */
    private String comstand;
    /** 终端接入广播电视网模式 */
    private String broadtel;
    /** 终端管理员名称 */
    private String manager;
    /** 终端管理员电话 */
    private String managertel;
    /** 终端交互时间 */
    private String intertime;
    /** 创建时间 */
    private String createdtime;
    /** 是否可用 */
    private Boolean isuse;
    /** 终端手机号码 */
    private String phone;
    /** RDS码 */
    private String rds;
    /** 调频接收频率(终端可收转广播频率 ) */
    private String fmfrequency;
    /** 终端流量使用限制，单位MB */
    private Float trafficlimit;

    /** 终端位置图片 */
    private String pic;

    /** 父地域ID */
    private String parentaid;

    public void setTid(String tid)
    {
        this.tid = tid;
    }

    public String getTid()
    {
        return tid;
    }
    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public String getTname()
    {
        return tname;
    }
    public void setAid(String aid)
    {
        this.aid = aid;
    }

    public String getAid()
    {
        return aid;
    }
    public void setAname(String aname)
    {
        this.aname = aname;
    }

    public String getAname()
    {
        return aname;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUserid()
    {
        return userid;
    }
    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return uname;
    }
    public void setLastaccesstime(String lastaccesstime)
    {
        this.lastaccesstime = lastaccesstime;
    }

    public String getLastaccesstime()
    {
        return lastaccesstime;
    }
    public void setFacid(String facid)
    {
        this.facid = facid;
    }

    public String getFacid()
    {
        return facid;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setComstand(String comstand)
    {
        this.comstand = comstand;
    }

    public String getComstand()
    {
        return comstand;
    }
    public void setBroadtel(String broadtel)
    {
        this.broadtel = broadtel;
    }

    public String getBroadtel()
    {
        return broadtel;
    }
    public void setManager(String manager)
    {
        this.manager = manager;
    }

    public String getManager()
    {
        return manager;
    }
    public void setManagertel(String managertel)
    {
        this.managertel = managertel;
    }

    public String getManagertel()
    {
        return managertel;
    }
    public void setIntertime(String intertime)
    {
        this.intertime = intertime;
    }

    public String getIntertime()
    {
        return intertime;
    }
    public void setCreatedtime(String createdtime)
    {
        this.createdtime = createdtime;
    }

    public String getCreatedtime()
    {
        return createdtime;
    }
    public void setIsuse(Boolean isuse)
    {
        this.isuse = isuse;
    }

    public Boolean getIsuse()
    {
        return isuse;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setRds(String rds)
    {
        this.rds = rds;
    }

    public String getRds()
    {
        return rds;
    }
    public void setFmfrequency(String fmfrequency)
    {
        this.fmfrequency = fmfrequency;
    }

    public String getFmfrequency()
    {
        return fmfrequency;
    }
    public void setTrafficlimit(Float trafficlimit)
    {
        this.trafficlimit = trafficlimit;
    }

    public Float getTrafficlimit()
    {
        return trafficlimit;
    }

    public String getParentaid()
    {
        return parentaid;
    }

    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("tid", getTid())
                .append("tname", getTname())
                .append("aid", getAid())
                .append("aname", getAname())
                .append("userid", getUserid())
                .append("uname", getUname())
                .append("lastaccesstime", getLastaccesstime())
                .append("facid", getFacid())
                .append("address", getAddress())
                .append("note", getNote())
                .append("comstand", getComstand())
                .append("broadtel", getBroadtel())
                .append("manager", getManager())
                .append("managertel", getManagertel())
                .append("intertime", getIntertime())
                .append("createdtime", getCreatedtime())
                .append("isuse", getIsuse())
                .append("phone", getPhone())
                .append("rds", getRds())
                .append("fmfrequency", getFmfrequency())
                .append("trafficlimit", getTrafficlimit())
                .append("parentaid", getParentaid())
                .append("pic", getPic())
                .toString();
    }
}
