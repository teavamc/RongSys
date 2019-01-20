package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;

import com.ruoyi.village.domain.Villagefamily;
import com.ruoyi.village.service.IVillagefamilyService;
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
public class VillagefamilyController extends BaseController {
    private String prefix = "village/villagefamily";

    @Autowired
    private IVillagefamilyService villagefamilyService;

    @RequiresPermissions("village:villageFamily:view")
    @GetMapping()
    public String VillageFamily(){return prefix+"/villagefamily";}

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }
    /**
     * 新增保存小村家事
     */
    @RequiresPermissions("village:villagefamily:add")
    @Log(title = "小村家事", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Villagefamily villagefamily)
    {
        return toAjax(villagefamilyService.insertvillagefamily(villagefamily));
    }

    /**
     * 修改小村家事数据
     * @param jsid
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{jsid}")
    public String edit(@PathVariable("jsid") Integer jsid , ModelMap mmap){
        Villagefamily villagefamily = villagefamilyService.selectByfbid(jsid);
        mmap.put("villagefamily", villagefamily);
        return prefix + "/edit";
    }
    /**
     * 修改保存小村家事
     */
    @RequiresPermissions("village:villagefamily:edit")
    @Log(title = "小村家事", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Villagefamily villagefamily) {
        System.out.println(villagefamily.toString());
        return toAjax(villagefamilyService.updatevillagefamily(villagefamily));}

    /**
     * 获取小村家事数据
     * @return
     */
    //@RequiresPermissions("village:villagefamily:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo List(Villagefamily villagefamily){
        startPage();
        List<Villagefamily> list = villagefamilyService.selectvillagefamilylist(villagefamily);
        return getDataTable(list);
    }

    /**
     * 删除小村家事
     */
    @RequiresPermissions("village:villageFamily:remove")
    @Log(title = "删除小村家事", businessType = BusinessType.DELETE)
    @PostMapping( "/remove/{jsid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("jsid") String jsid)
    {
        return toAjax(villagefamilyService.deletevillagefamilybyids(jsid));
    }
}