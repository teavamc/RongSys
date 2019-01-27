package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.web.domain.Server;
import com.ruoyi.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.framework.web.base.BaseController;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysLogininforService logininforService;



    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        Server server = new Server();
        try {
            server.copyTo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mmap.put("server", server);
        mmap.put("loginlog",logininforService.selectLoginLogforIndex());
//        mmap.put("bindex",bindexService.countAny());
        mmap.put("version", Global.getVersion());
        return "main";
    }
}
