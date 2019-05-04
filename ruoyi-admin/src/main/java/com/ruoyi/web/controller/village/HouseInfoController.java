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
import com.ruoyi.village.domain.HouseInfo;
import com.ruoyi.village.service.IHouseInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 房屋 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/houseInfo")
public class HouseInfoController extends BaseController
{
    private String prefix = "village/houseInfo";
	
	@Autowired
	private IHouseInfoService houseInfoService;
	
	@RequiresPermissions("village:houseInfo:view")
	@GetMapping()
	public String houseInfo()
	{
	    return prefix + "/houseInfo";
	}
	
	/**
	 * 查询房屋列表
	 */
	@RequiresPermissions("village:houseInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HouseInfo houseInfo)
	{
		startPage();
        List<HouseInfo> list = houseInfoService.selectHouseInfoList(houseInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出房屋列表
	 */
	@RequiresPermissions("village:houseInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HouseInfo houseInfo)
    {
    	List<HouseInfo> list = houseInfoService.selectHouseInfoList(houseInfo);
        ExcelUtil<HouseInfo> util = new ExcelUtil<HouseInfo>(HouseInfo.class);
        return util.exportExcel(list, "houseInfo");
    }
	
	/**
	 * 新增房屋
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存房屋
	 */
	@RequiresPermissions("village:houseInfo:add")
	@Log(title = "房屋", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HouseInfo houseInfo)
	{		
		return toAjax(houseInfoService.insertHouseInfo(houseInfo));
	}

	/**
	 * 修改房屋
	 */
	@GetMapping("/edit/{hid}")
	public String edit(@PathVariable("hid") Integer hid, ModelMap mmap)
	{
		HouseInfo houseInfo = houseInfoService.selectHouseInfoById(hid);
		mmap.put("houseInfo", houseInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存房屋
	 */
	@RequiresPermissions("village:houseInfo:edit")
	@Log(title = "房屋", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HouseInfo houseInfo)
	{		
		return toAjax(houseInfoService.updateHouseInfo(houseInfo));
	}
	
	/**
	 * 删除房屋
	 */
	@RequiresPermissions("village:houseInfo:remove")
	@Log(title = "房屋", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(houseInfoService.deleteHouseInfoByIds(ids));
	}
	
}
