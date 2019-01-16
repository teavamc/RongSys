package com.ruoyi.web.controller.village;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.village.domain.Complaintsmessages;
import com.ruoyi.village.service.IComplaintsmessagesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * @program: lyb_RongSys
 * @description: 投诉咨询 信息操作处理
 * @author: Mr.Liu
 * @create: 2019-01-14 16:04
 **/
@Controller
@RequestMapping("/village/Complaintsmessages")
public class ComplaintsmessagesController extends BaseController {

    private String prefix = "/village/Complaintsmessages";

    @Autowired
    private IComplaintsmessagesService complaintsmessagesService;

    @RequiresPermissions("village:Complaintsmessages:view")
    @GetMapping()
    public String Complaintsmessages(){
        return prefix+"/Complaintsmessages";
    }

    /**
     * 投诉咨询列表
     * @param complaintmessages
     * @return
     */
    //@RequiresPermissions("village:Complaintsmessages:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Complaintsmessages complaintmessages){
        startPage();
        List<Complaintsmessages> list = complaintsmessagesService.selectComplaintsList_first();
        return getDataTable(list);
    }
//    /**
//     * 根据fbid删除数据
//     * @param id
//     * @return
//     */
//    @RequiresPermissions("village:Complaintsmessages:delete")
//    @PostMapping("/delete")
//    @ResponseBody
//    public AjaxResult delete(String id){
//        return toAjax(complaintsmessagesService.deleteComplaintsByids(id));
//    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增保存投诉咨询
     */
    @RequiresPermissions("village:Complaintsmessages:add")
    @Log(title = "投诉咨询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Complaintsmessages complaintsmessages)
    {
        return toAjax(complaintsmessagesService.insertcomplaintsmessages(complaintsmessages));
    }
    /**
     * 修改投诉咨询
     */
    @GetMapping("/edit/{fbid}")
    public String edit(@PathVariable("fbid") Integer fbid, ModelMap mmap)
    {
        Complaintsmessages complaintsmessages = complaintsmessagesService.selectByfbid(fbid);
        mmap.put("complaintsmessages", complaintsmessages);
        return prefix + "/edit";
    }
    /**
     * 修改保存投诉咨询
     */
    @RequiresPermissions("village:complaintsmessages:edit")
    @Log(title = "投诉咨询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Complaintsmessages complaintsmessages)
    {
        return toAjax(complaintsmessagesService.updateComplaintsmessages(complaintsmessages));
    }
    /**
     * 删除投诉咨询
     */
    @RequiresPermissions("village:complaintsmessages:remove")
    @Log(title = "删除投诉咨询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove/{fbid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("fbid") String fbid)
    {
        System.out.println("*******"+fbid);
        return toAjax(complaintsmessagesService.deleteComplaintsmessagesByIds(fbid));
    }
}
