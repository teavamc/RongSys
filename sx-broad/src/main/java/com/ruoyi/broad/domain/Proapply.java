package com.ruoyi.broad.domain;

/**
 * @author 张超 teavamc
 * @Description: 节目申请
 * @ClassName Proapply
 * @date 2019/3/2 12:11
 **/
public class Proapply {
    private String paid;//节目申请-节目ID
    private String pname;//节目名称
    private String userid;//用户ID
    private String requires;//录制要求
    private Boolean isemergency;//是否紧急
    private String timelimit;//时间限制要求
    private String filename;//要求文稿名
    private String fileurl;//要求文稿路径
    private String submittime;//申请提交时间
    private Boolean iscancel;//是否撤回
    private Boolean isreply;//是否回复
    private String replytime;//回复时间日期
    private String replyperson;//录音人员
    private String replyprogramid;//回复上传节目编号
    private Boolean islisten;//申请人是否审听
    private Boolean isread;//管理员是否阅读
    private String nopassreason;
    private Boolean listenpass;//是否审听通过
    private Integer nopasstimes;
    public String getPaid() {
        return paid;
    }
    public void setPaid(String paid) {
        this.paid = paid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getRequires() {
        return requires;
    }
    public void setRequires(String requires) {
        this.requires = requires;
    }
    public Boolean getIsemergency() {
        return isemergency;
    }
    public void setIsemergency(Boolean isemergency) {
        this.isemergency = isemergency;
    }
    public String getTimelimit() {
        return timelimit;
    }
    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFileurl() {
        return fileurl;
    }
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
    public String getSubmittime() {
        return submittime;
    }
    public void setSubmittime(String submittime) {
        this.submittime = submittime;
    }
    public Boolean getIscancel() {
        return iscancel;
    }
    public void setIscancel(Boolean iscancel) {
        this.iscancel = iscancel;
    }
    public Boolean getIsreply() {
        return isreply;
    }
    public void setIsreply(Boolean isreply) {
        this.isreply = isreply;
    }
    public String getReplytime() {
        return replytime;
    }
    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }
    public String getReplyperson() {
        return replyperson;
    }
    public void setReplyperson(String replyperson) {
        this.replyperson = replyperson;
    }
    public Boolean getIslisten() {
        return islisten;
    }
    public void setIslisten(Boolean islisten) {
        this.islisten = islisten;
    }
    public Boolean getIsread() {
        return isread;
    }
    public void setIsread(Boolean isread) {
        this.isread = isread;
    }
    public String getReplyprogramid() {
        return replyprogramid;
    }
    public void setReplyprogramid(String replyprogramid) {
        this.replyprogramid = replyprogramid;
    }
    public String getNopassreason() {
        return nopassreason;
    }
    public void setNopassreason(String nopassreason) {
        this.nopassreason = nopassreason;
    }
    public Boolean getListenpass() {
        return listenpass;
    }
    public void setListenpass(Boolean listenpass) {
        this.listenpass = listenpass;
    }
    public Integer getNopasstimes() {
        return nopasstimes;
    }
    public void setNopasstimes(Integer nopasstimes) {
        this.nopasstimes = nopasstimes;
    }

}
