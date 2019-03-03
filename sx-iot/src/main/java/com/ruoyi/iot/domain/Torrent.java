package com.ruoyi.iot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 终端运转表 torrent
 * 
 * @author 张超
 * @date 2019-03-03
 */
public class Torrent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 数据id */
	private Integer dataid;
	/** 终端imei */
	private String IMEI;
	/** 电池一电压 */
	private String pow1;
	/** 电池组电压 */
	private String grouppow;
	/** 18V1输出电压 */
	private String outv1;
	/** 18V2输出电压 */
	private String outv2;
	/** 24V输出电压 */
	private String v24;
	/** 28V输出电压 */
	private String v28;
	/** 外部电压 */
	private String extendpow;
	/** 太阳能电压 */
	private String solarpow;
	/** 充电状态 */
	private String charge;
	/** 工作状态 */
	private String work;
	/** 采集时间 */
	private Date time;
	/** 网络IP */
	private String iP;

	public void setDataid(Integer dataid) 
	{
		this.dataid = dataid;
	}

	public Integer getDataid() 
	{
		return dataid;
	}
	public void setIMEI(String IMEI)
	{
		this.IMEI = IMEI;
	}

	public String getIMEI() 
	{
		return IMEI;
	}
	public void setPow1(String pow1) 
	{
		this.pow1 = pow1;
	}

	public String getPow1() 
	{
		return pow1;
	}
	public void setGrouppow(String grouppow) 
	{
		this.grouppow = grouppow;
	}

	public String getGrouppow() 
	{
		return grouppow;
	}
	public void setOutv1(String outv1) 
	{
		this.outv1 = outv1;
	}

	public String getOutv1() 
	{
		return outv1;
	}
	public void setOutv2(String outv2) 
	{
		this.outv2 = outv2;
	}

	public String getOutv2() 
	{
		return outv2;
	}
	public void setV24(String v24) 
	{
		this.v24 = v24;
	}

	public String getV24() 
	{
		return v24;
	}
	public void setV28(String v28) 
	{
		this.v28 = v28;
	}

	public String getV28() 
	{
		return v28;
	}
	public void setExtendpow(String extendpow) 
	{
		this.extendpow = extendpow;
	}

	public String getExtendpow() 
	{
		return extendpow;
	}
	public void setSolarpow(String solarpow) 
	{
		this.solarpow = solarpow;
	}

	public String getSolarpow() 
	{
		return solarpow;
	}
	public void setCharge(String charge) 
	{
		this.charge = charge;
	}

	public String getCharge() 
	{
		return charge;
	}
	public void setWork(String work) 
	{
		this.work = work;
	}

	public String getWork() 
	{
		return work;
	}
	public void setTime(Date time) 
	{
		this.time = time;
	}

	public Date getTime() 
	{
		return time;
	}
	public void setIP(String iP) 
	{
		this.iP = iP;
	}

	public String getIP() 
	{
		return iP;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dataid", getDataid())
            .append("IMEI", getIMEI())
            .append("pow1", getPow1())
            .append("grouppow", getGrouppow())
            .append("outv1", getOutv1())
            .append("outv2", getOutv2())
            .append("v24", getV24())
            .append("v28", getV28())
            .append("extendpow", getExtendpow())
            .append("solarpow", getSolarpow())
            .append("charge", getCharge())
            .append("work", getWork())
            .append("time", getTime())
            .append("iP", getIP())
            .toString();
    }
}
