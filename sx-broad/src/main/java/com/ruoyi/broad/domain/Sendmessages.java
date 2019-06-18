package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 短信发送记录表 sendmessages
 *
 * @author 张超
 * @date 2019-01-11
 */
public class Sendmessages extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 短信id */
	private Integer smid;
	/** 手机号 */
	private String smobile;
	/** 内容 */
	private String scontent;
	/** 是否发送 */
	private Boolean issend;
	/** 发送时间 */
	private String sendtime;
	/** 截止时间 */
	private String endtime;
	/** 是否有效 */
	private String remark;
	/** 接收短信的终端编号，或接收短信的用户编号，或紧急节目申请短信的接收人姓名 */
	private String tid;
	/** 特殊语种 */
	private String spelanguage;
	/** 发送次数 */
	private Integer sendtimes;

	public void setSmid(Integer smid)
	{
		this.smid = smid;
	}

	public Integer getSmid()
	{
		return smid;
	}
	public void setSmobile(String smobile)
	{
		this.smobile = smobile;
	}

	public String getSmobile()
	{
		return smobile;
	}
	public void setScontent(String scontent)
	{
		this.scontent = scontent;
	}

	public String getScontent()
	{
		return scontent;
	}
	public void setIssend(Boolean issend)
	{
		this.issend = issend;
	}

	public Boolean getIssend()
	{
		return issend;
	}
	public void setSendtime(String sendtime)
	{
		this.sendtime = sendtime;
	}

	public String getSendtime()
	{
		return sendtime;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public void setEndtime(String endtime)
	{
		this.endtime = endtime;
	}

	public String getEndtime()
	{
		return endtime;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setTid(String tid)
	{
		this.tid = tid;
	}

	public String getTid()
	{
		return tid;
	}
	public void setSpelanguage(String spelanguage)
	{
		this.spelanguage = spelanguage;
	}

	public String getSpelanguage()
	{
		return spelanguage;
	}
	public void setSendtimes(Integer sendtimes)
	{
		this.sendtimes = sendtimes;
	}

	public Integer getSendtimes()
	{
		return sendtimes;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("smid", getSmid())
				.append("smobile", getSmobile())
				.append("scontent", getScontent())
				.append("issend", getIssend())
				.append("sendtime", getSendtime())
				.append("remark", getRemark())
				.append("tid", getTid())
				.append("spelanguage", getSpelanguage())
				.append("sendtimes", getSendtimes())
				.toString();
	}
}
