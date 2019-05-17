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
import com.ruoyi.village.domain.PlowlandInfo;
import com.ruoyi.village.service.IPlowlandInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 耕地 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/plowlandInfo")
public class PlowlandInfoController extends BaseController
{
    private String prefix = "village/plowlandInfo";
	
	@Autowired
	private IPlowlandInfoService plowlandInfoService;
	
	@RequiresPermissions("village:plowlandInfo:view")
	@GetMapping()
	public String plowlandInfo()
	{
	    return prefix + "/plowlandInfo";
	}
	
	/**
	 * 查询耕地列表
	 */
	@RequiresPermissions("village:plowlandInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PlowlandInfo plowlandInfo)
	{
		startPage();
        List<PlowlandInfo> list = plowlandInfoService.selectPlowlandInfoList(plowlandInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出耕地列表
	 */
	@RequiresPermissions("village:plowlandInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlowlandInfo plowlandInfo)
    {
    	List<PlowlandInfo> list = plowlandInfoService.selectPlowlandInfoList(plowlandInfo);
        ExcelUtil<PlowlandInfo> util = new ExcelUtil<PlowlandInfo>(PlowlandInfo.class);
        return util.exportExcel(list, "plowlandInfo");
    }
	
	/**
	 * 新增耕地
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存耕地
	 */
	@RequiresPermissions("village:plowlandInfo:add")
	@Log(title = "耕地", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PlowlandInfo plowlandInfo)
	{		
		return toAjax(plowlandInfoService.insertPlowlandInfo(plowlandInfo));
	}

	/**
	 * 修改耕地
	 */
	@GetMapping("/edit/{pid}")
	public String edit(@PathVariable("pid") Integer pid, ModelMap mmap)
	{
		PlowlandInfo plowlandInfo = plowlandInfoService.selectPlowlandInfoById(pid);
		mmap.put("plowlandInfo", plowlandInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存耕地
	 */
	@RequiresPermissions("village:plowlandInfo:edit")
	@Log(title = "耕地", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PlowlandInfo plowlandInfo)
	{		
		return toAjax(plowlandInfoService.updatePlowlandInfo(plowlandInfo));
	}
	
	/**
	 * 删除耕地
	 */
	@RequiresPermissions("village:plowlandInfo:remove")
	@Log(title = "耕地", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(plowlandInfoService.deletePlowlandInfoByIds(ids));
	}
	
}
