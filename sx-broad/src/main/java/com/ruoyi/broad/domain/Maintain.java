package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 终端维护记录表 terminal_maintain
 * 
 * @author 张超
 * @date 2019-01-15
 */
public class Maintain extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 终端维护记录-维护ID */
	private Integer tmid;
	/** 终端ID */
	private String tid;
	/** 故障现象 */
	private String fault;
	/** 维护人员 */
	private String mstaff;
	/** 维护时间 */
	private String createtime;
	/** 备注 */
	private String remark;

	public void setTmid(Integer tmid) 
	{
		this.tmid = tmid;
	}

	public Integer getTmid() 
	{
		return tmid;
	}
	public void setTid(String tid) 
	{
		this.tid = tid;
	}

	public String getTid() 
	{
		return tid;
	}
	public void setFault(String fault) 
	{
		this.fault = fault;
	}

	public String getFault() 
	{
		return fault;
	}
	public void setMstaff(String mstaff) 
	{
		this.mstaff = mstaff;
	}

	public String getMstaff() 
	{
		return mstaff;
	}
	public void setCreatetime(String createtime) 
	{
		this.createtime = createtime;
	}

	public String getCreatetime() 
	{
		return createtime;
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
            .append("tmid", getTmid())
            .append("tid", getTid())
            .append("fault", getFault())
            .append("mstaff", getMstaff())
            .append("createtime", getCreatetime())
            .append("remark", getRemark())
            .toString();
    }
}
