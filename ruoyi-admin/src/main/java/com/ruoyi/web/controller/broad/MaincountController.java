package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Maincount;
import com.ruoyi.broad.service.IMaincountService;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
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
 * 终端维护记录表统计 terminal_maincount
 *
 * @author 张鸿权
 * @date 2019-06-09
 */
@Controller
@RequestMapping("/broad/maincount")
public class MaincountController extends BaseController
{
    private String prefix = "broad/maincount";

	@Autowired
	private IMaincountService maincountService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IMessageService messageService;
	@RequiresPermissions("broad:maincount:view")
	@GetMapping()
	public String maincount()
	{
	    return prefix + "/maincount";
	}

	/**
	 * 查询终端维护记录列表
	 */
	@RequiresPermissions("broad:maincount:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Maincount maincount)
	{
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		int returnId = new Long(userid).intValue();
		int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
		if(roleid != 1){
			String aid;
			aid = sysUserService.selectAid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Aid
			maincount.setAid(aid);
		}
		startPage();
        List<Maincount> list = maincountService.selectMaincountList(maincount);
		return getDataTable(list);
	}


	/**
	 * 导出终端维护记录列表
	 */
	@RequiresPermissions("broad:maincount:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Maincount maincount)
    {
    	List<Maincount> list = maincountService.selectMaincountList(maincount);
        ExcelUtil<Maincount> util = new ExcelUtil<Maincount>(Maincount.class);
        return util.exportExcel(list, "maincount");
    }

	/**
	 * 打开终端维护记录详情页
	 */
	@GetMapping("/detail/{tid}")
	public String detail(@PathVariable("tid")String tid,ModelMap mmap)
	{
		mmap.put("tid",tid);
		mmap.put("listBySjid",maincountService.selectMaincountById(tid));
		return prefix + "/detail";
	}

}
