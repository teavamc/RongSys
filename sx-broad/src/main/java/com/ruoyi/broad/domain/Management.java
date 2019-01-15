package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 终端管理表 terminal_management
 * 
 * @author 张超
 * @date 2019-01-15
 */
public class Management extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String tid;
	/** 节目播出主管单位 */
	private String supervisionUnit;
	/** 安全播出责任单位 */
	private String accountabilityUnit;
	/** 安装点经度 */
	private Double longitude;
	/** 纬度 */
	private Double latitude;
	/** 覆盖用户 */
	private Integer families;
	/** 覆盖人口数 */
	private Integer population;
	/** 二次覆盖模式 */
	private String twoOverlayMode;
	/** 二次覆盖发射频率 */
	private String twoTransmitFrequency;
	/** 二次覆盖终端数 */
	private Integer twoOverlayNumber;
	/** 二次覆盖用户数 */
	private Integer twoOverlayFamiles;
	/** 二次覆盖人口数 */
	private Integer twoOverlayPopulations;
	/** 耗电指数 */
	private Double powerConsumption;
	/** 其它应急系统技术 */
	private String otherTechnology;
	/** 应急演练期限 */
	private String drillingPeriod;
	/** 备用电瓶配置 */
	private String standbyBattery;
	/** 回传数据技术模块 */
	private String playbacksMode;
	/** 维护经费 */
	private Double maintenanceFunds;
	/** 是否有效 */
	private String remark;
	/** 备用电池电压 */
	private Integer backupBatteryVoltage;

	public void setTid(String tid) 
	{
		this.tid = tid;
	}

	public String getTid() 
	{
		return tid;
	}
	public void setSupervisionUnit(String supervisionUnit) 
	{
		this.supervisionUnit = supervisionUnit;
	}

	public String getSupervisionUnit() 
	{
		return supervisionUnit;
	}
	public void setAccountabilityUnit(String accountabilityUnit) 
	{
		this.accountabilityUnit = accountabilityUnit;
	}

	public String getAccountabilityUnit() 
	{
		return accountabilityUnit;
	}
	public void setLongitude(Double longitude) 
	{
		this.longitude = longitude;
	}

	public Double getLongitude() 
	{
		return longitude;
	}
	public void setLatitude(Double latitude) 
	{
		this.latitude = latitude;
	}

	public Double getLatitude() 
	{
		return latitude;
	}
	public void setFamilies(Integer families) 
	{
		this.families = families;
	}

	public Integer getFamilies() 
	{
		return families;
	}
	public void setPopulation(Integer population) 
	{
		this.population = population;
	}

	public Integer getPopulation() 
	{
		return population;
	}
	public void setTwoOverlayMode(String twoOverlayMode) 
	{
		this.twoOverlayMode = twoOverlayMode;
	}

	public String getTwoOverlayMode() 
	{
		return twoOverlayMode;
	}
	public void setTwoTransmitFrequency(String twoTransmitFrequency) 
	{
		this.twoTransmitFrequency = twoTransmitFrequency;
	}

	public String getTwoTransmitFrequency() 
	{
		return twoTransmitFrequency;
	}
	public void setTwoOverlayNumber(Integer twoOverlayNumber) 
	{
		this.twoOverlayNumber = twoOverlayNumber;
	}

	public Integer getTwoOverlayNumber() 
	{
		return twoOverlayNumber;
	}
	public void setTwoOverlayFamiles(Integer twoOverlayFamiles) 
	{
		this.twoOverlayFamiles = twoOverlayFamiles;
	}

	public Integer getTwoOverlayFamiles() 
	{
		return twoOverlayFamiles;
	}
	public void setTwoOverlayPopulations(Integer twoOverlayPopulations) 
	{
		this.twoOverlayPopulations = twoOverlayPopulations;
	}

	public Integer getTwoOverlayPopulations() 
	{
		return twoOverlayPopulations;
	}
	public void setPowerConsumption(Double powerConsumption) 
	{
		this.powerConsumption = powerConsumption;
	}

	public Double getPowerConsumption() 
	{
		return powerConsumption;
	}
	public void setOtherTechnology(String otherTechnology) 
	{
		this.otherTechnology = otherTechnology;
	}

	public String getOtherTechnology() 
	{
		return otherTechnology;
	}
	public void setDrillingPeriod(String drillingPeriod) 
	{
		this.drillingPeriod = drillingPeriod;
	}

	public String getDrillingPeriod() 
	{
		return drillingPeriod;
	}
	public void setStandbyBattery(String standbyBattery) 
	{
		this.standbyBattery = standbyBattery;
	}

	public String getStandbyBattery() 
	{
		return standbyBattery;
	}
	public void setPlaybacksMode(String playbacksMode) 
	{
		this.playbacksMode = playbacksMode;
	}

	public String getPlaybacksMode() 
	{
		return playbacksMode;
	}
	public void setMaintenanceFunds(Double maintenanceFunds) 
	{
		this.maintenanceFunds = maintenanceFunds;
	}

	public Double getMaintenanceFunds() 
	{
		return maintenanceFunds;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setBackupBatteryVoltage(Integer backupBatteryVoltage) 
	{
		this.backupBatteryVoltage = backupBatteryVoltage;
	}

	public Integer getBackupBatteryVoltage() 
	{
		return backupBatteryVoltage;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tid", getTid())
            .append("supervisionUnit", getSupervisionUnit())
            .append("accountabilityUnit", getAccountabilityUnit())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("families", getFamilies())
            .append("population", getPopulation())
            .append("twoOverlayMode", getTwoOverlayMode())
            .append("twoTransmitFrequency", getTwoTransmitFrequency())
            .append("twoOverlayNumber", getTwoOverlayNumber())
            .append("twoOverlayFamiles", getTwoOverlayFamiles())
            .append("twoOverlayPopulations", getTwoOverlayPopulations())
            .append("powerConsumption", getPowerConsumption())
            .append("otherTechnology", getOtherTechnology())
            .append("drillingPeriod", getDrillingPeriod())
            .append("standbyBattery", getStandbyBattery())
            .append("playbacksMode", getPlaybacksMode())
            .append("maintenanceFunds", getMaintenanceFunds())
            .append("remark", getRemark())
            .append("backupBatteryVoltage", getBackupBatteryVoltage())
            .toString();
    }
}
