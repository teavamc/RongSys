package com.ruoyi.broad.domain;

/**
 * @author 张超 teavamc
 * @Description:节目上传
 * @ClassName Program
 * @date 2019/2/25 18:37
 **/
public class Program {
    private String fid;//节目申请-节目ID
    private String fname;//节目名称
    private String userid;//用户ID
    private String remark;//备注
    private Boolean ispublic;//是否公共
    private String filename;//要求文稿名
    private String address;//要求文稿路径
    private String urls;//要求文稿路径
    private String createdtime;//申请提交时间
    private String flenth;//节目时长
    private Double fsize;//文件大小
    private Boolean islisten;//是否审听
    private Boolean ptype;//节目类型，是否是录制节目
    public String getFid() {
        return fid;
    }
    public void setFid(String fid) {
        this.fid = fid;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Boolean getIspublic() {
        return ispublic;
    }
    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getUrls() {
        return urls;
    }
    public void setUrls(String urls) {
        this.urls = urls;
    }
    public String getCreatedtime() {
        return createdtime;
    }
    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }
    public String getFlenth() {
        return flenth;
    }
    public void setFlenth(String flenth) {
        this.flenth = flenth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getPtype() {
        return ptype;
    }
    public void setPtype(Boolean ptype) {
        this.ptype = ptype;
    }
    public Boolean getIslisten() {
        return islisten;
    }
    public void setIslisten(Boolean islisten) {
        this.islisten = islisten;
    }
    public Double getFsize() {
        return fsize;
    }
    public void setFsize(Double fsize) {
        this.fsize = fsize;
    }
}
