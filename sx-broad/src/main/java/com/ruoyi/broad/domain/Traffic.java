package com.ruoyi.broad.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 流量表 terminal_traffic
 *
 * @author 张超
 * @date 2019-01-15
 */
public class Traffic extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 终端流量使用信息表-id */
	private Integer ttid;
	/** 终端编号 */
	private String tid;
	/** 所属分组编号 */
	private String aid;
	/** 使用流量，单位MB */
	private Float usetraffic;
	/** 终端流量使用限制，单位MB */
	private Float trafficlimit;
	@Excel(name = "流量状态", readConverterExp = "0=正常,1=超量")
	private String status;
	/** 流量统计时间 */
	private String lasttime;
	/** 备注 */
	private String remark;
	/** 终端名称 */
	private String tname;
	/** 所属分组 */
	private String aname;
	/** 所属用户 */
	private String uname;
	/** 启用状态 */
	private String isuse;
	public void setTtid(Integer ttid)
	{
		this.ttid = ttid;
	}
	public Integer getTtid()
	{
		return ttid;
	}

	public void setTid(String tid)
	{
		this.tid = tid;
	}
	public String getTid()
	{
		return tid;
	}

	public void setAid(String aid)
	{
		this.aid = aid;
	}

	public String getAid()
	{
		return aid;
	}

	public Float getTrafficlimit() { return trafficlimit; }
	public void setTrafficlimit(Float trafficlimit) { this.trafficlimit = trafficlimit; }

	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}

	public Float getUsetraffic()
	{
		return usetraffic;
	}
	public void setUsetraffic(Float usetraffic)
	{
		this.usetraffic = usetraffic;
	}

	public String getLasttime()
	{
		return lasttime;
	}
	public void setLasttime(String lasttime)
	{
		this.lasttime = lasttime;
	}


	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return remark;
	}

	public String getTname()
	{
		return tname;
	}
	public void setTname(String tname)
	{
		this.tname = tname;
	}

	public String getAname()
	{
		return aname;
	}
	public void setAname(String aname)
	{
		this.aname = aname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getUname()
	{
		return uname;
	}

	public void setIsuse(String isuse)
	{
		this.isuse = isuse;
	}
	public String getIsuse()
	{
		return isuse;
	}
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("ttid", getTtid())
				.append("tid", getTid())
				.append("aid", getAid())
				.append("usetraffic", getUsetraffic())
				.append("trafficlimit", getTrafficlimit())
				.append("status", getStatus())
				.append("lasttime", getLasttime())
				.append("remark", getRemark())
				.append("uname", getUname())
				.append("aname", getAname())
				.append("tname", getTname())
				.append("isuse", getIsuse())
				.toString();
	}
}
