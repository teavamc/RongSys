package com.ruoyi.village.domain;

/**
 * @program: lyb_RongSys
 * @description: 求职招聘
 * @author: Mr.Liu
 * @create: 2019-01-15 14:05
 **/
public class recruitment {
    /**招聘信息编号*/
    private String jid;
    /**职位类型**/
    private String jtype;
    /**招聘公司**/
    private String company;
    /**公司图片路径**/
    private String picurl;
    /**视频地址**/
    private String vidurl;
    /**职位**/
    private String position;
    /**职位介绍**/
    private String introduction;
    /**公司网站**/
    private String url;
    /**招聘内容**/
    private String content;
    /**联系方式**/
    private String phone;
    /**电子邮箱**/
    private String email;
    /**招聘发布日期**/
    private String date;
    /**招聘人数**/
    private int num;
    /**招聘开始时间**/
    private String bedate;
    /**招聘结束时间**/
    private String endate;
    /**招聘发布人编号**/
    private int uid;
    /**发布人用户名**/
    private String uname;
    /**用户所属地区村社区 aid**/
    private String aid;
    /**是否有效**/
    private int remark;

    public recruitment() {
    }

    public recruitment(String jid, String jtype, String company,
                       String picurl, String vidurl, String position,
                       String introduction, String url, String content,
                       String phone, String email, String date, int num,
                       String bedate, String endate, int uid, String uname,
                       String aid, int remark) {
        this.jid = jid;
        this.jtype = jtype;
        this.company = company;
        this.picurl = picurl;
        this.vidurl = vidurl;
        this.position = position;
        this.introduction = introduction;
        this.url = url;
        this.content = content;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.num = num;
        this.bedate = bedate;
        this.endate = endate;
        this.uid = uid;
        this.uname = uname;
        this.aid = aid;
        this.remark = remark;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getVidurl() {
        return vidurl;
    }

    public void setVidurl(String vidurl) {
        this.vidurl = vidurl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBedate() {
        return bedate;
    }

    public void setBedate(String bedate) {
        this.bedate = bedate;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }
}
