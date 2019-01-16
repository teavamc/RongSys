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
 * @program: dyq_RongSys
 * @description: 政策信息 信息操作处理
 * @author: Mr.Dai
 * @create: 2019-01-14 16:04
 **/
@Controller
@RequestMapping("/village/politics")
public class PoliticsController extends BaseController {

    private String prefix = "/village/politics";

    @Autowired
    private IPoliticsService politicsService;

    @RequiresPermissions("village:politics:view")
    @GetMapping()
    public String Politics(){
        return prefix+"/politics";
    }

    /**
     * 投诉咨询列表
     * @param politics
     * @return
     */
    @RequiresPermissions("village:politics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Politics politics){
        startPage();
        List<Politics> list = politicsService.selectPoliticsList_first();
        return getDataTable(list);
    }
    /**
     * 根据shiid删除数据
     * @param id
     * @return
     */
    @RequiresPermissions("village:politics:delete")
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        return toAjax(politicsService.deletePoliticsByids(id));
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    @GetMapping("/edit")
    public String edit(){return prefix+"/edit";}
}
