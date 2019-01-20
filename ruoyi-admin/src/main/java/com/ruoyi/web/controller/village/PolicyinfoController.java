package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Policyinfo;
import com.ruoyi.village.service.IPolicyinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: daiyuqi1999_RongSys
 * @description: 公告信息 信息操作处理
 * @author: Mr.Dai
 * @create: 2019-01-14 16:04
 **/
@Controller
@RequestMapping("/village/policyinfo")
public class PolicyinfoController extends BaseController {

    private String prefix = "village/policyinfo";

    @Autowired
    private IPolicyinfoService policyinfoService;

    @RequiresPermissions("village:policyinfo:view")
    @GetMapping()
    public String Politic(){
        return prefix+"/policyinfo";
    }

    /**
     * 公告信息列表
     * @param policyinfo
     * @return
     */
    //@RequiresPermissions("village:policyinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Policyinfo policyinfo){
        startPage();
        List<Policyinfo> list = policyinfoService.selectPolicyinfoList(policyinfo);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增保存公告信息
     */
    @RequiresPermissions("village:policyinfo:add")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Policyinfo policyinfo)
    {
        return toAjax(policyinfoService.insertpolicyinfo(policyinfo));
    }
    /**
     * 修改公告信息
     */
    @GetMapping("/edit/{poinid}")
    public String edit(@PathVariable("poinid") Integer poinid, ModelMap mmap)
    {
        Policyinfo policyinfo = policyinfoService.selectBypoinid(poinid);
        mmap.put("policyinfo", policyinfo);
        return prefix + "/edit";
    }
    /**
     * 修改保存公告
     */
    @RequiresPermissions("village:policyinfo:edit")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Policyinfo policyinfo)
    {
        return toAjax(policyinfoService.updatePolicyinfo(policyinfo));
    }
    /**
     * 删除公告信息
     */
    @RequiresPermissions("village:policyinfo:remove")
    @Log(title = "删除公告信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove/{poinid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("poinid") String poinid)
    {
        System.out.println("*******"+poinid);
        return toAjax(policyinfoService.deletePolicyinfoByIds(poinid));
    }
}
