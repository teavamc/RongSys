package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Maintain;
import com.ruoyi.broad.domain.MaintainApply;
import com.ruoyi.broad.service.IMaintainApplyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ASUS on 2019/7/13.
 */
@Controller
@RequestMapping("/broad/maintainApply")
public class MaintainApplyController extends BaseController {
    private String prefix = "broad/maintainApply";

    @Autowired
    private IMaintainApplyService iMaintainApplyService;

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping()
    public String maintainApply()
    {
        return prefix + "/maintainApply";
    }

    @PostMapping("/list")
    @Log(title = "申请维护记录", businessType = BusinessType.UPDATE)
    @ResponseBody
    public TableDataInfo list(MaintainApply maintainApply) {
        SysUser currentUser = ShiroUtils.getSysUser();  //从session中获取当前登陆用户的userid
        Long userid = currentUser.getUserId();
        int returnid = new Long(userid).intValue();
        int roleid = iSysUserService.selectRoleid(returnid); //通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        if (roleid == 1)
        {
            startPage();
            List<MaintainApply> list = iMaintainApplyService.selectMaintainApplyList(maintainApply);
            return getDataTable(list);
        }else
        {
            maintainApply.setUid(userid);
            startPage();
            List<MaintainApply> list = iMaintainApplyService.selectMaintainApplyList(maintainApply);
            return getDataTable(list);
        }
    }
    @GetMapping("/add")
    public String addMaintainApply()
    {
        return prefix + "/add";
    }

//    @RequiresPermissions("broad:maintain:maintainapply")
    @Log(title = "申请维护记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaintainApply maintainApply)
    {
        return toAjax(iMaintainApplyService.insertMaintainApply(maintainApply));
    }
}
