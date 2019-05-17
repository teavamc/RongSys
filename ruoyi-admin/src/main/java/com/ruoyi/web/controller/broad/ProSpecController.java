package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.ProSpec;
import com.ruoyi.broad.service.IProSpecService;
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
 * 特种节目管理
 *
 * @author 周博
 * @date 2019-03-27
 */

@Controller
@RequestMapping("/broad/spec")
public class ProSpecController extends BaseController {
    private String prefix = "broad/spec";

    @Autowired
    private IProSpecService proSpecService;
    @Autowired
    private ISysUserService sysUserService;
    @GetMapping()
    public String spec()
    {
        return prefix + "/spec";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProSpec proSpec)
    {
        SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
        Long userid =  currentUser.getUserId();
        int returnId = new Long(userid).intValue();
        int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
        if(roleid == 1) {
            startPage();
            List<ProSpec> list = proSpecService.selectProSpecList(proSpec);
            return getDataTable(list);
        }else{
            proSpec.setUserid(userid);
            startPage();
            List<ProSpec> list = proSpecService.selectProSpecList(proSpec);
            return getDataTable(list);
        }
    }
}
