package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;

import com.ruoyi.village.domain.VillageFamily;
import com.ruoyi.village.service.IVillageFamilyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 小村家事 信息操作处理
 * @author: Mr.Liu
 * @create: 2019-01-15 15:07
 **/
@Controller
@RequestMapping("/village/VillageFamily")
public class VillageFamilyController extends BaseController {
    private String prefix = "village/VillageFamily";

    @Autowired
    private IVillageFamilyService iVillageFamilyService;

    @RequiresPermissions("village:VillageFamily:view")
    @GetMapping()
    public String VillageFamily(){return prefix+"/VillageFamily";}

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }
    /**
     * 新增保存小村家事
     */
    @RequiresPermissions("village:VillageFamily:add")
    @Log(title = "小村家事", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VillageFamily villageFamily)
    {
        return toAjax(iVillageFamilyService.insertVillageFamily(villageFamily));
    }

    /**
     * 修改小村家事数据
     * @param jsid
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{jsid}")
    public String edit(@PathVariable("jsid") Integer jsid , ModelMap mmap){
        VillageFamily villageFamily = iVillageFamilyService.selectByfbid(jsid);
        mmap.put("villageFamily", villageFamily);
        return prefix + "/edit";
    }
    /**
     * 修改保存小村家事
     */
    @RequiresPermissions("village:VillageFamily:edit")
    @Log(title = "小村家事", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VillageFamily villageFamily) {return toAjax(iVillageFamilyService.updateVillageFamily(villageFamily));}

    /**
     * 获取小村家事数据
     * @return
     */
    //@RequiresPermissions("village:VillageFamily:remove")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo List(VillageFamily villageFamily){
        startPage();
        List<VillageFamily> list = iVillageFamilyService.selectVillageFamilyList(villageFamily);
        return getDataTable(list);
    }

    /**
     * 删除小村家事
     */
    @RequiresPermissions("village:VillageFamily:remove")
    @Log(title = "删除小村家事", businessType = BusinessType.DELETE)
    @PostMapping( "/remove/{jsid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("jsid") String jsid)
    {
        return toAjax(iVillageFamilyService.deleteVillageFamilyByid(jsid));
    }
}
