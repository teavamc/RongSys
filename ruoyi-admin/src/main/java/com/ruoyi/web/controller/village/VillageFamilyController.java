package com.ruoyi.web.controller.village;

import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;

import com.ruoyi.village.domain.VillageFamily;
import com.ruoyi.village.service.IVillageFamilyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo List(VillageFamily villageFamily){
        startPage();
        List<VillageFamily> list = iVillageFamilyService.selectVillageFamilyList(villageFamily);
        return getDataTable(list);
    }
}
