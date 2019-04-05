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
	public void setUsetraffic(Float usetraffic)
	{
		this.usetraffic = usetraffic;
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
	public void setLasttime(String lasttime)
	{
		this.lasttime = lasttime;
	}

	public String getLasttime()
	{
		return lasttime;
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
				.append("ttid", getTtid())
				.append("tid", getTid())
				.append("usetraffic", getUsetraffic())
				.append("trafficlimit", getTrafficlimit())
				.append("status", getStatus())
				.append("lasttime", getLasttime())
				.append("remark", getRemark())
				.toString();
	}
}
