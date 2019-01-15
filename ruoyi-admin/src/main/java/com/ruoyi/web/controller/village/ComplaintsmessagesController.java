package com.ruoyi.web.controller.village;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ruoyi.village.domain.Complaintsmessages;
import com.ruoyi.village.service.IComplaintsmessagesService;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询Controller
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
        List<Complaintsmessages> list = complaintsmessagesService.selectComplaintsList();
        return getDataTable(list);
    }
    /**
     * 根据fbid删除数据
     * @param id
     * @return
     */
    @RequiresPermissions("village:Complaintsmessages:delete")
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id){
        return toAjax(complaintsmessagesService.deleteComplaintsByids(id));
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"add";
    }

    @GetMapping("/edit")
    public String edit(){return prefix+"edit";}
}
