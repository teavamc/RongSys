package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.ProSinmanage;
import com.ruoyi.broad.domain.Termap;
import com.ruoyi.broad.service.IProListService;
import com.ruoyi.broad.service.IProSinmanageService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName proSinmanageWarningController
 * @date 2019/3/9 22:03
 **/
public class proSinmanageWarningController extends BaseController
{
    private String prefix = "broad/proSinmanageWarning";

    @Autowired
    private IProSinmanageService proSinmanageService;
    @Autowired
    private IProListService proListService;
    @Autowired
    private ISysUserService sysUserService;


    @RequiresPermissions("broad:proSinmanageWarning:view")
    @GetMapping()
    public String proSinmanageWarning()
    {
        return prefix + "/proSinmanageWarning";
    }

    /**
     * 查询节目播出单列表
     */
    @RequiresPermissions("broad:proSinmanageWarning:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
        long userid =  currentUser.getUserId();
        int returnId = new Long(userid).intValue();
        int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        List<ProSinmanage> list ;
        startPage();
        /*判断用户等级，若为超级管理员则可查看全部内容，否则只能查看自己的内容*/
        if(roleid != 1){
            list = proSinmanageService.selectProSinmanageListForWarning(returnId);//通过所获取的Aid去查询用户所属区域对应的数据
        }else{
            list = proSinmanageService.selectProSinmanageListForWarning(0);}
        return getDataTable(list);
    }

    /**
     * 打开节目单详情页
     */
    @GetMapping("/detail/{sjid}")
    public String detail(@PathVariable("sjid")String sjid,ModelMap mmap)
    {
        mmap.put("sjid",sjid);
        mmap.put("listBySjid",proListService.selectProListListByPid(sjid));
        return prefix + "/detail";
    }

    /**
     * 导出节目播出单列表
     */
    @RequiresPermissions("broad:proSinmanageWarning:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSinmanage proSinmanage)
    {
        List<ProSinmanage> list = proSinmanageService.selectProSinmanageList(proSinmanage);
        ExcelUtil<ProSinmanage> util = new ExcelUtil<ProSinmanage>(ProSinmanage.class);
        return util.exportExcel(list, "proSinmanage");
    }

    /**
     * 新增节目播出单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存节目播出单
     */
    @RequiresPermissions("broad:proSinmanageWarning:add")
    @Log(title = "节目播出单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProSinmanage proSinmanage)
    {
        return toAjax(proSinmanageService.insertProSinmanage(proSinmanage));
    }

    /**
     * 修改节目播出单
     */
    @GetMapping("/edit/{sfid}")
    public String edit(@PathVariable("sfid") Integer sfid, ModelMap mmap)
    {
        ProSinmanage proSinmanage = proSinmanageService.selectProSinmanageById(sfid);
        mmap.put("proSinmanage", proSinmanage);
        return prefix + "/edit";
    }

    /**
     * 修改保存节目播出单
     */
    @RequiresPermissions("broad:proSinmanageWarning:edit")
    @Log(title = "节目播出单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSinmanage proSinmanage)
    {
        return toAjax(proSinmanageService.updateProSinmanage(proSinmanage));
    }

    /**
     * 删除节目播出单
     */
    @RequiresPermissions("broad:proSinmanageWarning:remove")
    @Log(title = "节目播出单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proSinmanageService.deleteProSinmanageByIds(ids));
    }
}
