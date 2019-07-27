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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASUS on 2019/7/13.
 * @author 陈霞
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
    public String addMaintainApply(ModelMap modelMap)
    {
        //从session中获取当前登陆用户的 username、phone、userid
        SysUser currentUser = ShiroUtils.getSysUser();
        String username =  currentUser.getUserName();
		String phone =  currentUser.getPhonenumber();
        Long userid =  currentUser.getUserId();
        String aid;
        int returnId = new Long(userid).intValue();
        //通过所获取的userid去广播用户表中查询用户所属区域的Aid
        aid = iSysUserService.selectAid(returnId);
        //	将aid、fname、uname传至add.html中
//		mmap.put("aid", aid);//这里获得的aid是来自ry-》tb_user_admin
        modelMap.put("username", username);
		modelMap.put("userphone", phone);
        return prefix + "/add";
    }

//    @RequiresPermissions("broad:maintain:maintainapply")
    @Log(title = "申请维护记录增加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaintainApply maintainApply)
    {
        return toAjax(iMaintainApplyService.insertMaintainApply(maintainApply));
    }
    @PostMapping("/remove")
    @Log(title = "申请维护记录删除",businessType = BusinessType.DELETE)
    @RequiresPermissions("broad:maintainApply:remove")
    @ResponseBody
    public AjaxResult removeMaintainApply(String ids)
    {
         return toAjax(iMaintainApplyService.deleteMaintainApplyById(ids));
    }

    @GetMapping("/detail/{maid}")
    @Log(title = "申请维护记录详细")
    public String detail(@PathVariable("maid") String maid,ModelMap mmp)
    {
        mmp.put("listById",iMaintainApplyService.selectMaintainApplyById(maid));
        return prefix + "/detail";
    }

    /**
     * 修改终端维护记录
     */
    @GetMapping("/edit/{maid}")
    public String edit(@PathVariable("maid") String maid, ModelMap mmap)
    {
        MaintainApply maintainApply = iMaintainApplyService.selectMaintainApplyById(maid);
        mmap.put("maintainApply", maintainApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存终端维护记录
     */
    @RequiresPermissions("broad:maintain:edit")
    @Log(title = "申请维护记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaintainApply maintainApply)
    {
        return toAjax(iMaintainApplyService.updateMaintainApply(maintainApply));
    }
}
