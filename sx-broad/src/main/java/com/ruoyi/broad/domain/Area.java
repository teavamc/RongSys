package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 终端地域表 area
 * 
 * @author 张超
 * @date 2019-01-17
 */
public class Area extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 地域ID */
	private String aid;
	/** 父地域ID */
	private String parentaid;
	/** 地域名称 */
	private String aname;
	/** 备注 */
	private String note;

	public void setAid(String aid) 
	{
		this.aid = aid;
	}

	public String getAid() 
	{
		return aid;
	}
	public void setParentaid(String parentaid) 
	{
		this.parentaid = parentaid;
	}

	public String getParentaid() 
	{
		return parentaid;
	}
	public void setAname(String aname) 
	{
		this.aname = aname;
	}

	public String getAname() 
	{
		return aname;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("aid", getAid())
            .append("parentaid", getParentaid())
            .append("aname", getAname())
            .append("note", getNote())
            .toString();
    }
}
