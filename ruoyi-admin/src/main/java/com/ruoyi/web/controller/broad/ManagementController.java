package com.ruoyi.web.controller.broad;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.broad.domain.Management;
import com.ruoyi.broad.service.IManagementService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 终端管理 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-15
 */
@Controller
@RequestMapping("/broad/management")
public class ManagementController extends BaseController
{
    private String prefix = "broad/management";
	
	@Autowired
	private IManagementService managementService;
	
	@RequiresPermissions("broad:management:view")
	@GetMapping()
	public String management()
	{
	    return prefix + "/management";
	}
	
	/**
	 * 查询终端管理列表
	 */
	@RequiresPermissions("broad:management:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Management management)
	{
		startPage();
        List<Management> list = managementService.selectManagementList(management);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出终端管理列表
	 */
	@RequiresPermissions("broad:management:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Management management)
    {
    	List<Management> list = managementService.selectManagementList(management);
        ExcelUtil<Management> util = new ExcelUtil<Management>(Management.class);
        return util.exportExcel(list, "management");
    }
	
	/**
	 * 新增终端管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存终端管理
	 */
	@RequiresPermissions("broad:management:add")
	@Log(title = "终端管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Management management)
	{		
		return toAjax(managementService.insertManagement(management));
	}

	/**
	 * 修改终端管理
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") String tid, ModelMap mmap)
	{
		Management management = managementService.selectManagementById(tid);
		mmap.put("management", management);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存终端管理
	 */
	@RequiresPermissions("broad:management:edit")
	@Log(title = "终端管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Management management)
	{		
		return toAjax(managementService.updateManagement(management));
	}
	
	/**
	 * 删除终端管理
	 */
	@RequiresPermissions("broad:management:remove")
	@Log(title = "终端管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(managementService.deleteManagementByIds(ids));
	}
	
}
