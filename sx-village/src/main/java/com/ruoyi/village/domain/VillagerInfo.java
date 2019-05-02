package com.ruoyi.village.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 村民表 villager_info
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
public class VillagerInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 数据编号 */
	private Integer vid;
	/** 地域编号 */
	private String aid;
	/** 村民姓名 */
	private String name;
	/** 年龄 */
	private String age;
	/** 性别 */
	private String sex;
	/** 籍贯 */
	private String nativeplace;
	/** 民族 */
	private String nation;
	/** 政治面貌 */
	private String politics;
	/** 入党年月 */
	private String partyjoindate;
	/** 文化程度 */
	private String edulevel;
	/** 婚姻状况 */
	private String marital;
	/** 身份证号码 */
	private String idcard;
	/** 联系方式 */
	private String phone;
	/** 健康状况 */
	private String health;
	/** 特种（残疾）信息 */
	private String special;
	/** 优抚信息 */
	private String entitle;
	/** 计生情况 */
	private String familyplan;
	/** 医疗情况 */
	private String medical;
	/** 补助情况 */
	private String subsidy;
	/** 保险情况 */
	private String insurance;
	/** 犯罪史 */
	private String criminal;
	/** 吸毒史 */
	private String drug;
	/** 驾照 */
	private String drive;
	/** 车辆 */
	private String car;
	/** 车辆类型 */
	private String vtype;
	/** 车牌号 */
	private String carnum;
	/** 职业 */
	private String work;
	/** 工作单位 */
	private String company;
	/** 户籍地址 */
	private String pra;
	/** 现居地址 */
	private String home;
	/** 所属村组 */
	private String grouptype;
	/** 住房性质 */
	private String house;
	/** 户口性质 */
	private String prt;

	public void setVid(Integer vid) 
	{
		this.vid = vid;
	}

	public Integer getVid() 
	{
		return vid;
	}
	public void setAid(String aid) 
	{
		this.aid = aid;
	}

	public String getAid() 
	{
		return aid;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAge(String age) 
	{
		this.age = age;
	}

	public String getAge() 
	{
		return age;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setNativeplace(String nativeplace)
	{
		this.nativeplace = nativeplace;
	}

	public String getNativeplace()
	{
		return nativeplace;
	}
	public void setNation(String nation) 
	{
		this.nation = nation;
	}

	public String getNation() 
	{
		return nation;
	}
	public void setPolitics(String politics) 
	{
		this.politics = politics;
	}

	public String getPolitics() 
	{
		return politics;
	}
	public void setPartyjoindate(String partyjoindate) 
	{
		this.partyjoindate = partyjoindate;
	}

	public String getPartyjoindate() 
	{
		return partyjoindate;
	}
	public void setEdulevel(String edulevel) 
	{
		this.edulevel = edulevel;
	}

	public String getEdulevel() 
	{
		return edulevel;
	}
	public void setMarital(String marital) 
	{
		this.marital = marital;
	}

	public String getMarital() 
	{
		return marital;
	}
	public void setIdcard(String idcard) 
	{
		this.idcard = idcard;
	}

	public String getIdcard() 
	{
		return idcard;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setHealth(String health) 
	{
		this.health = health;
	}

	public String getHealth() 
	{
		return health;
	}
	public void setSpecial(String special) 
	{
		this.special = special;
	}

	public String getSpecial() 
	{
		return special;
	}
	public void setEntitle(String entitle) 
	{
		this.entitle = entitle;
	}

	public String getEntitle() 
	{
		return entitle;
	}
	public void setFamilyplan(String familyplan) 
	{
		this.familyplan = familyplan;
	}

	public String getFamilyplan() 
	{
		return familyplan;
	}
	public void setMedical(String medical) 
	{
		this.medical = medical;
	}

	public String getMedical() 
	{
		return medical;
	}
	public void setSubsidy(String subsidy) 
	{
		this.subsidy = subsidy;
	}

	public String getSubsidy() 
	{
		return subsidy;
	}
	public void setInsurance(String insurance) 
	{
		this.insurance = insurance;
	}

	public String getInsurance() 
	{
		return insurance;
	}
	public void setCriminal(String criminal) 
	{
		this.criminal = criminal;
	}

	public String getCriminal() 
	{
		return criminal;
	}
	public void setDrug(String drug) 
	{
		this.drug = drug;
	}

	public String getDrug() 
	{
		return drug;
	}
	public void setDrive(String drive) 
	{
		this.drive = drive;
	}

	public String getDrive() 
	{
		return drive;
	}
	public void setCar(String car) 
	{
		this.car = car;
	}

	public String getCar() 
	{
		return car;
	}
	public void setVtype(String vtype) 
	{
		this.vtype = vtype;
	}

	public String getVtype() 
	{
		return vtype;
	}
	public void setCarnum(String carnum) 
	{
		this.carnum = carnum;
	}

	public String getCarnum() 
	{
		return carnum;
	}
	public void setWork(String work) 
	{
		this.work = work;
	}

	public String getWork() 
	{
		return work;
	}
	public void setCompany(String company) 
	{
		this.company = company;
	}

	public String getCompany() 
	{
		return company;
	}
	public void setPra(String pra) 
	{
		this.pra = pra;
	}

	public String getPra() 
	{
		return pra;
	}
	public void setHome(String home) 
	{
		this.home = home;
	}

	public String getHome() 
	{
		return home;
	}
	public void setGrouptype(String grouptype) 
	{
		this.grouptype = grouptype;
	}

	public String getGrouptype() 
	{
		return grouptype;
	}
	public void setHouse(String house) 
	{
		this.house = house;
	}

	public String getHouse() 
	{
		return house;
	}
	public void setPrt(String prt) 
	{
		this.prt = prt;
	}

	public String getPrt() 
	{
		return prt;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vid", getVid())
            .append("aid", getAid())
            .append("name", getName())
            .append("age", getAge())
            .append("sex", getSex())
            .append("nativeplace", getNativeplace())
            .append("nation", getNation())
            .append("politics", getPolitics())
            .append("partyjoindate", getPartyjoindate())
            .append("edulevel", getEdulevel())
            .append("marital", getMarital())
            .append("idcard", getIdcard())
            .append("phone", getPhone())
            .append("health", getHealth())
            .append("special", getSpecial())
            .append("entitle", getEntitle())
            .append("familyplan", getFamilyplan())
            .append("medical", getMedical())
            .append("subsidy", getSubsidy())
            .append("insurance", getInsurance())
            .append("criminal", getCriminal())
            .append("drug", getDrug())
            .append("drive", getDrive())
            .append("car", getCar())
            .append("vtype", getVtype())
            .append("carnum", getCarnum())
            .append("work", getWork())
            .append("company", getCompany())
            .append("pra", getPra())
            .append("home", getHome())
            .append("grouptype", getGrouptype())
            .append("house", getHouse())
            .append("prt", getPrt())
            .toString();
    }
}
