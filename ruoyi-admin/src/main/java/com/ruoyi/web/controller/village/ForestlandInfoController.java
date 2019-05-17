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
import com.ruoyi.village.domain.ForestlandInfo;
import com.ruoyi.village.service.IForestlandInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 林地 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/forestlandInfo")
public class ForestlandInfoController extends BaseController
{
    private String prefix = "village/forestlandInfo";
	
	@Autowired
	private IForestlandInfoService forestlandInfoService;
	
	@RequiresPermissions("village:forestlandInfo:view")
	@GetMapping()
	public String forestlandInfo()
	{
	    return prefix + "/forestlandInfo";
	}
	
	/**
	 * 查询林地列表
	 */
	@RequiresPermissions("village:forestlandInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ForestlandInfo forestlandInfo)
	{
		startPage();
        List<ForestlandInfo> list = forestlandInfoService.selectForestlandInfoList(forestlandInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出林地列表
	 */
	@RequiresPermissions("village:forestlandInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ForestlandInfo forestlandInfo)
    {
    	List<ForestlandInfo> list = forestlandInfoService.selectForestlandInfoList(forestlandInfo);
        ExcelUtil<ForestlandInfo> util = new ExcelUtil<ForestlandInfo>(ForestlandInfo.class);
        return util.exportExcel(list, "forestlandInfo");
    }
	
	/**
	 * 新增林地
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存林地
	 */
	@RequiresPermissions("village:forestlandInfo:add")
	@Log(title = "林地", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ForestlandInfo forestlandInfo)
	{		
		return toAjax(forestlandInfoService.insertForestlandInfo(forestlandInfo));
	}

	/**
	 * 修改林地
	 */
	@GetMapping("/edit/{fid}")
	public String edit(@PathVariable("fid") Integer fid, ModelMap mmap)
	{
		ForestlandInfo forestlandInfo = forestlandInfoService.selectForestlandInfoById(fid);
		mmap.put("forestlandInfo", forestlandInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存林地
	 */
	@RequiresPermissions("village:forestlandInfo:edit")
	@Log(title = "林地", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ForestlandInfo forestlandInfo)
	{		
		return toAjax(forestlandInfoService.updateForestlandInfo(forestlandInfo));
	}
	
	/**
	 * 删除林地
	 */
	@RequiresPermissions("village:forestlandInfo:remove")
	@Log(title = "林地", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(forestlandInfoService.deleteForestlandInfoByIds(ids));
	}
	
}
