package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.MaintainApply;
import com.ruoyi.broad.service.IMaintainApplyService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
}
