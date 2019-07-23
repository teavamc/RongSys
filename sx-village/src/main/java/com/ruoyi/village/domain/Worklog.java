package com.ruoyi.village.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 工作记录表 worklog
 * 
 * @author 张鸿权
 * @date 2019-07-23
 */
public class Worklog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目数据编号 */
	private Integer wid;
	/** 标题 */
	private String wtitle;
	/** 文件路径 */
	private String wpic;
	/** 类别 */
	private String wtype;
	/** 内容 */
	private String content;
	/** 负责人姓名 */
	private String wname;
	/** 负责人手机号 */
	private String wphone;
	/** 发布人编号 */
	private Integer uid;
	/** 点击数 */
	private Integer greadtotal;
	/** 发布日期 */
	private String pushdate;
	/** 发布人姓名 */
	private String uname;
	/** 是否有效 */
	private String remark;
	/** 用户所属地区村社区 aid */
	private String aid;
	/** 工作进度“0”为未完成，“1”为已完成 */
	private Integer ptype;

	public void setWid(Integer wid) 
	{
		this.wid = wid;
	}

	public Integer getWid() 
	{
		return wid;
	}
	public void setWtitle(String wtitle) 
	{
		this.wtitle = wtitle;
	}

	public String getWtitle() 
	{
		return wtitle;
	}
	public void setWpic(String wpic) 
	{
		this.wpic = wpic;
	}

	public String getWpic() 
	{
		return wpic;
	}
	public void setWtype(String wtype) 
	{
		this.wtype = wtype;
	}

	public String getWtype() 
	{
		return wtype;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setWname(String wname) 
	{
		this.wname = wname;
	}

	public String getWname() 
	{
		return wname;
	}
	public void setWphone(String wphone) 
	{
		this.wphone = wphone;
	}

	public String getWphone() 
	{
		return wphone;
	}
	public void setUid(Integer uid) 
	{
		this.uid = uid;
	}

	public Integer getUid() 
	{
		return uid;
	}
	public void setGreadtotal(Integer greadtotal) 
	{
		this.greadtotal = greadtotal;
	}

	public Integer getGreadtotal() 
	{
		return greadtotal;
	}
	public void setPushdate(String pushdate)
	{
		this.pushdate = pushdate;
	}

	public String getPushdate()
	{
		return pushdate;
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
	public void setAid(String aid) 
	{
		this.aid = aid;
	}

	public String getAid() 
	{
		return aid;
	}
	public void setPtype(Integer ptype) 
	{
		this.ptype = ptype;
	}

	public Integer getPtype() 
	{
		return ptype;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wid", getWid())
            .append("wtitle", getWtitle())
            .append("wpic", getWpic())
            .append("wtype", getWtype())
            .append("content", getContent())
            .append("wname", getWname())
            .append("wphone", getWphone())
            .append("uid", getUid())
            .append("greadtotal", getGreadtotal())
            .append("pushdate", getPushdate())
            .append("uname", getUname())
            .append("remark", getRemark())
            .append("aid", getAid())
            .append("ptype", getPtype())
            .toString();
    }
}
