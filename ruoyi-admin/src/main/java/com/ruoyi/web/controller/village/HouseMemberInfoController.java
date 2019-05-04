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
import com.ruoyi.village.domain.HouseMemberInfo;
import com.ruoyi.village.service.IHouseMemberInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 村户 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/houseMemberInfo")
public class HouseMemberInfoController extends BaseController
{
    private String prefix = "village/houseMemberInfo";
	
	@Autowired
	private IHouseMemberInfoService houseMemberInfoService;
	
	@RequiresPermissions("village:houseMemberInfo:view")
	@GetMapping()
	public String houseMemberInfo()
	{
	    return prefix + "/houseMemberInfo";
	}
	
	/**
	 * 查询村户列表
	 */
	@RequiresPermissions("village:houseMemberInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HouseMemberInfo houseMemberInfo)
	{
		startPage();
        List<HouseMemberInfo> list = houseMemberInfoService.selectHouseMemberInfoList(houseMemberInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出村户列表
	 */
	@RequiresPermissions("village:houseMemberInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HouseMemberInfo houseMemberInfo)
    {
    	List<HouseMemberInfo> list = houseMemberInfoService.selectHouseMemberInfoList(houseMemberInfo);
        ExcelUtil<HouseMemberInfo> util = new ExcelUtil<HouseMemberInfo>(HouseMemberInfo.class);
        return util.exportExcel(list, "houseMemberInfo");
    }
	
	/**
	 * 新增村户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村户
	 */
	@RequiresPermissions("village:houseMemberInfo:add")
	@Log(title = "村户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HouseMemberInfo houseMemberInfo)
	{		
		return toAjax(houseMemberInfoService.insertHouseMemberInfo(houseMemberInfo));
	}

	/**
	 * 修改村户
	 */
	@GetMapping("/edit/{hmid}")
	public String edit(@PathVariable("hmid") Integer hmid, ModelMap mmap)
	{
		HouseMemberInfo houseMemberInfo = houseMemberInfoService.selectHouseMemberInfoById(hmid);
		mmap.put("houseMemberInfo", houseMemberInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村户
	 */
	@RequiresPermissions("village:houseMemberInfo:edit")
	@Log(title = "村户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HouseMemberInfo houseMemberInfo)
	{		
		return toAjax(houseMemberInfoService.updateHouseMemberInfo(houseMemberInfo));
	}
	
	/**
	 * 删除村户
	 */
	@RequiresPermissions("village:houseMemberInfo:remove")
	@Log(title = "村户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(houseMemberInfoService.deleteHouseMemberInfoByIds(ids));
	}
	
}
