package com.ruoyi.village.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 资产清查表 asset_assessment
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public class AssetAssessment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer aaid;
	/** 地域编号 */
	private String aid;
	/** 村组名称 */
	private String grouptype;
	/** 建设用地 */
	private String constructionland;
	/** 工矿仓储用地 */
	private String imsland;
	/** 商服用地 */
	private String businessland;
	/** 农村宅基地 */
	private String homestead;
	/** 公共服务用地 */
	private String publicland;
	/** 交通水利用地 */
	private String twland;
	/** 其他建设用地 */
	private String otherland;

	public void setAaid(Integer aaid) 
	{
		this.aaid = aaid;
	}

	public Integer getAaid() 
	{
		return aaid;
	}
	public void setAid(String aid) 
	{
		this.aid = aid;
	}

	public String getAid() 
	{
		return aid;
	}
	public void setGrouptype(String grouptype) 
	{
		this.grouptype = grouptype;
	}

	public String getGrouptype() 
	{
		return grouptype;
	}
	public void setConstructionland(String constructionland) 
	{
		this.constructionland = constructionland;
	}

	public String getConstructionland() 
	{
		return constructionland;
	}
	public void setImsland(String imsland) 
	{
		this.imsland = imsland;
	}

	public String getImsland() 
	{
		return imsland;
	}
	public void setBusinessland(String businessland)
	{
		this.businessland = businessland;
	}

	public String getBusinessland()
	{
		return businessland;
	}
	public void setHomestead(String homestead) 
	{
		this.homestead = homestead;
	}

	public String getHomestead() 
	{
		return homestead;
	}
	public void setPublicland(String publicland) 
	{
		this.publicland = publicland;
	}

	public String getPublicland() 
	{
		return publicland;
	}
	public void setTwland(String twland) 
	{
		this.twland = twland;
	}

	public String getTwland() 
	{
		return twland;
	}
	public void setOtherland(String otherland) 
	{
		this.otherland = otherland;
	}

	public String getOtherland() 
	{
		return otherland;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("aaid", getAaid())
            .append("aid", getAid())
            .append("grouptype", getGrouptype())
            .append("constructionland", getConstructionland())
            .append("imsland", getImsland())
            .append(" businessland", getBusinessland())
            .append("homestead", getHomestead())
            .append("publicland", getPublicland())
            .append("twland", getTwland())
            .append("otherland", getOtherland())
            .toString();
    }
}
