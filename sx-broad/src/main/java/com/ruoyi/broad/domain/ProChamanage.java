package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 节目转播管理表 pro_chamanage
 * 
 * @author 张超
 * @date 2019-03-02
 */
public class ProChamanage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 转播频道管理 */
	private Integer cid;
	/** 节目 */
	private String cname;
	/** 频道 */
	private String frequencies;
	/** 所属用户 */
	private String userid;
	/** 节目备注 */
	private String pronote;
	/** 备注 */
	private String remark;

	public void setCid(Integer cid) 
	{
		this.cid = cid;
	}

	public Integer getCid() 
	{
		return cid;
	}
	public void setCname(String cname) 
	{
		this.cname = cname;
	}

	public String getCname() 
	{
		return cname;
	}
	public void setFrequencies(String frequencies) 
	{
		this.frequencies = frequencies;
	}

	public String getFrequencies() 
	{
		return frequencies;
	}
	public void setUserid(String userid) 
	{
		this.userid = userid;
	}

	public String getUserid() 
	{
		return userid;
	}
	public void setPronote(String pronote) 
	{
		this.pronote = pronote;
	}

	public String getPronote() 
	{
		return pronote;
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
            .append("cid", getCid())
            .append("cname", getCname())
            .append("frequencies", getFrequencies())
            .append("userid", getUserid())
            .append("pronote", getPronote())
            .append("remark", getRemark())
            .toString();
    }
}
