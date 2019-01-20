package com.ruoyi.web.controller.village;

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
import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.service.IPartymemberService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 暮云党员 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-01-20
 */
@Controller
@RequestMapping("/village/partymember")
public class PartymemberController extends BaseController
{
    private String prefix = "village/partymember";
	
	@Autowired
	private IPartymemberService partymemberService;
	
	@RequiresPermissions("village:partymember:view")
	@GetMapping()
	public String partymember()
	{
	    return prefix + "/partymember";
	}
	
	/**
	 * 查询暮云党员列表
	 */
	@RequiresPermissions("village:partymember:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Partymember partymember)
	{
		startPage();
        List<Partymember> list = partymemberService.selectPartymemberList(partymember);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出暮云党员列表
	 */
	@RequiresPermissions("village:partymember:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Partymember partymember)
    {
    	List<Partymember> list = partymemberService.selectPartymemberList(partymember);
        ExcelUtil<Partymember> util = new ExcelUtil<Partymember>(Partymember.class);
        return util.exportExcel(list, "partymember");
    }
	
	/**
	 * 新增暮云党员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存暮云党员
	 */
	@RequiresPermissions("village:partymember:add")
	@Log(title = "暮云党员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Partymember partymember)
	{		
		return toAjax(partymemberService.insertPartymember(partymember));
	}

	/**
	 * 修改暮云党员
	 */
	@GetMapping("/edit/{pid}")
	public String edit(@PathVariable("pid") Integer pid, ModelMap mmap)
	{
		Partymember partymember = partymemberService.selectPartymemberById(pid);
		mmap.put("partymember", partymember);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存暮云党员
	 */
	@RequiresPermissions("village:partymember:edit")
	@Log(title = "暮云党员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Partymember partymember)
	{		
		return toAjax(partymemberService.updatePartymember(partymember));
	}
	
	/**
	 * 删除暮云党员
	 */
	@RequiresPermissions("village:partymember:remove")
	@Log(title = "暮云党员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(partymemberService.deletePartymemberByIds(ids));
	}
	
}
