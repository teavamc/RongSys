package com.ruoyi.web.controller.village;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Politics;
import com.ruoyi.village.service.IPoliticsService;
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
 * @description: 投诉咨询 信息操作处理
 * @author: Mr.Liu
 * @create: 2019-01-14 16:04
 **/
@Controller
@RequestMapping("/village/Politics")
public class PoliticsController extends BaseController {

    private String prefix = "/village/Politics";

    @Autowired
    private IPoliticsService politicsService;

    @RequiresPermissions("village:Politics:view")
    @GetMapping()
    public String Politics(){
        return prefix+"/Politics";
    }

    /**
     * 投诉咨询列表
     * @param politics
     * @return
     */
    @RequiresPermissions("village:Politics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Politics politics){
        startPage();
        List<Politics> list = politicsService.selectPoliticsList_first();
        return getDataTable(list);
    }
    /**
     * 根据fbid删除数据
     * @param id
     * @return
     */
    @RequiresPermissions("village:Politics:delete")
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        return toAjax(politicsService.deletePoliticsByids(id));
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"add";
    }

    @GetMapping("/edit")
    public String edit(){return prefix+"edit";}
}
