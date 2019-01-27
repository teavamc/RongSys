package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 系统访问记录表 sys_logininfor
 * 为Index对象设立的实体
 *
 * @author 张超
 */
public class SysLoginIndex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户账号 */
    private String loginName;

    /** 浏览器类型 */
    private String user_name;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地点 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 访问时间 */
    private String loginTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
    this.browser = browser;
}

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("loginName", getLoginName())
                .append("user_name",getUser_name())
                .append("ipaddr", getIpaddr())
                .append("loginLocation", getLoginLocation())
                .append("browser", getBrowser())
                .append("loginTime", getLoginTime())
                .toString();
    }
}