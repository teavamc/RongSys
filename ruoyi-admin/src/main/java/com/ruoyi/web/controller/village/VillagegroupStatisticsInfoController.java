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
import com.ruoyi.village.domain.VillagegroupStatisticsInfo;
import com.ruoyi.village.service.IVillagegroupStatisticsInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 村组统计 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/villagegroupStatisticsInfo")
public class VillagegroupStatisticsInfoController extends BaseController
{
    private String prefix = "village/villagegroupStatisticsInfo";
	
	@Autowired
	private IVillagegroupStatisticsInfoService villagegroupStatisticsInfoService;
	
	@RequiresPermissions("village:villagegroupStatisticsInfo:view")
	@GetMapping()
	public String villagegroupStatisticsInfo()
	{
	    return prefix + "/villagegroupStatisticsInfo";
	}
	
	/**
	 * 查询村组统计列表
	 */
	@RequiresPermissions("village:villagegroupStatisticsInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(VillagegroupStatisticsInfo villagegroupStatisticsInfo)
	{
		startPage();
        List<VillagegroupStatisticsInfo> list = villagegroupStatisticsInfoService.selectVillagegroupStatisticsInfoList(villagegroupStatisticsInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出村组统计列表
	 */
	@RequiresPermissions("village:villagegroupStatisticsInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VillagegroupStatisticsInfo villagegroupStatisticsInfo)
    {
    	List<VillagegroupStatisticsInfo> list = villagegroupStatisticsInfoService.selectVillagegroupStatisticsInfoList(villagegroupStatisticsInfo);
        ExcelUtil<VillagegroupStatisticsInfo> util = new ExcelUtil<VillagegroupStatisticsInfo>(VillagegroupStatisticsInfo.class);
        return util.exportExcel(list, "villagegroupStatisticsInfo");
    }
	
	/**
	 * 新增村组统计
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村组统计
	 */
	@RequiresPermissions("village:villagegroupStatisticsInfo:add")
	@Log(title = "村组统计", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(VillagegroupStatisticsInfo villagegroupStatisticsInfo)
	{		
		return toAjax(villagegroupStatisticsInfoService.insertVillagegroupStatisticsInfo(villagegroupStatisticsInfo));
	}

	/**
	 * 修改村组统计
	 */
	@GetMapping("/edit/{vgsid}")
	public String edit(@PathVariable("vgsid") Integer vgsid, ModelMap mmap)
	{
		VillagegroupStatisticsInfo villagegroupStatisticsInfo = villagegroupStatisticsInfoService.selectVillagegroupStatisticsInfoById(vgsid);
		mmap.put("villagegroupStatisticsInfo", villagegroupStatisticsInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村组统计
	 */
	@RequiresPermissions("village:villagegroupStatisticsInfo:edit")
	@Log(title = "村组统计", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(VillagegroupStatisticsInfo villagegroupStatisticsInfo)
	{		
		return toAjax(villagegroupStatisticsInfoService.updateVillagegroupStatisticsInfo(villagegroupStatisticsInfo));
	}
	
	/**
	 * 删除村组统计
	 */
	@RequiresPermissions("village:villagegroupStatisticsInfo:remove")
	@Log(title = "村组统计", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(villagegroupStatisticsInfoService.deleteVillagegroupStatisticsInfoByIds(ids));
	}
	
}
