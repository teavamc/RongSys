package com.ruoyi.broad.domain;

/**
 * 特种节目管理
 *
 * @author 周博
 * @date 2019-03-27
 */
public class ProSpec {
    private String fid;
    private String fname;
    private String filename;
    private String flenth;
    private String fsize;
    private String uname;
    private String createdtime;
    /** 操作（所属）用户编号 */
    private Long userid;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFlenth() {
        return flenth;
    }

    public void setFlenth(String flenth) {
        this.flenth = flenth;
    }

    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize;
    }

    public String getUname() {
        return uname;
    }
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }
}
