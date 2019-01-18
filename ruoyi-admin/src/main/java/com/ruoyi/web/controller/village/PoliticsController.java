package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Politics;
import com.ruoyi.village.service.IPoliticsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    private String prefix = "village/politics";

    @Autowired
    private IPoliticsService politicsService;

    @RequiresPermissions("village:politics:view")
    @GetMapping()
    public String Politic(){
        return prefix+"/politics";
    }

    /**
     * 投诉咨询列表
     * @param politics
     * @return
     */
    //@RequiresPermissions("village:politics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Politics politics){
        startPage();
        List<Politics> list = politicsService.selectPoliticsList(politics);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增保存投诉咨询
     */
    @RequiresPermissions("village:politics:add")
    @Log(title = "政策信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Politics politics)
    {
        return toAjax(politicsService.insertpolitics(politics));
    }
    /**
     * 修改政策信息
     */
    @GetMapping("/edit/{shiid}")
    public String edit(@PathVariable("shiid") Integer shiid, ModelMap mmap)
    {
        Politics politics = politicsService.selectByshiid(shiid);
        mmap.put("politics", politics);
        return prefix + "/edit";
    }
    /**
     * 修改保存政策
     */
    @RequiresPermissions("village:politics:edit")
    @Log(title = "政策信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Politics politics)
    {
        return toAjax(politicsService.updatePolitics(politics));
    }
    /**
     * 删除政策信息
     */
    @RequiresPermissions("village:politics:remove")
    @Log(title = "删除政策信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove/{shiid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("shiid") String shiid)
    {
        System.out.println("*******"+shiid);
        return toAjax(politicsService.deletePoliticsByIds(shiid));
    }
}
