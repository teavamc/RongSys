package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 节目单记录表 pro_list
 * 
 * @author 张超
 * @date 2019-03-02
 */
public class ProList extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	private String id;
	
	/** 节目编号 */
	private String pid;
	/** 操作记录 */
	private String ptp;
	/** 节目文件 */
	private String fN;
	/** 文件编号 */
	private String fid;
	/** 播放时间 */
	private String bt;
	/** 播放时长，只有电台转播有 */
	private String broadtime;
	/** 备注 */
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getPid()
	{
		return pid;
	}
	public void setPtp(String ptp) 
	{
		this.ptp = ptp;
	}

	public String getPtp() 
	{
		return ptp;
	}
	public void setFN(String fN) 
	{
		this.fN = fN;
	}

	public String getFN() 
	{
		return fN;
	}
	public void setFid(String fid)
	{
		this.fid = fid;
	}

	public String getFid()
	{
		return fid;
	}
	public void setBt(String bt) 
	{
		this.bt = bt;
	}

	public String getBt() 
	{
		return bt;
	}
	public void setBroadtime(String broadtime) 
	{
		this.broadtime = broadtime;
	}

	public String getBroadtime() 
	{
		return broadtime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pid", getPid())
            .append("ptp", getPtp())
            .append("fN", getFN())
            .append("fid", getFid())
            .append("bt", getBt())
            .append("broadtime", getBroadtime())
            .append("remark", getRemark())
            .toString();
    }
}
