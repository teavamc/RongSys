package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 节目播出单表 pro_sinmanage
 * 
 * @author 张超
 * @date 2019-03-02
 */
public class ProSinmanage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 节目播出单IDSin */
	private String sfid;
	/** 节目播出单类别 */
	private String scategory;
	/** 建立日期 */
	private String createtime;
	/** 播出日期 */
	private String broaddate;
	/** 操作（所属）用户 */
	private Long userid;

	/** 操作（所属）用户 */
	private String uname;
	/** 备注 */
	private String remark;
	/** 紧急播出单播放次数 */
	private String broadtimes;

	public void setSfid(String sfid)
	{
		this.sfid = sfid;
	}

	public String getSfid()
	{
		return sfid;
	}
	public void setScategory(String scategory) 
	{
		this.scategory = scategory;
	}

	public String getScategory() 
	{
		return scategory;
	}
	public void setCreatetime(String createtime) 
	{
		this.createtime = createtime;
	}

	public String getCreatetime() 
	{
		return createtime;
	}
	public void setBroaddate(String broaddate) 
	{
		this.broaddate = broaddate;
	}

	public String getBroaddate() 
	{
		return broaddate;
	}
	public void setUserid(Long userid)
	{
		this.userid = userid;
	}

	public Long getUserid()
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
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setBroadtimes(String broadtimes)
	{
		this.broadtimes = broadtimes;
	}

	public String getBroadtimes()
	{
		return broadtimes;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sfid", getSfid())
            .append("scategory", getScategory())
            .append("createtime", getCreatetime())
            .append("broaddate", getBroaddate())
            .append("userid", getUserid())
            .append("remark", getRemark())
            .append("broadtimes", getBroadtimes())
            .toString();
    }
}
