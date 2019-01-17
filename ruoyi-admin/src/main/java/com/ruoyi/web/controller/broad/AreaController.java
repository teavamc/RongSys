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
import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 终端地域 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-17
 */
@Controller
@RequestMapping("/broad/area")
public class AreaController extends BaseController
{
    private String prefix = "broad/area";
	
	@Autowired
	private IAreaService areaService;
	
	@RequiresPermissions("broad:area:view")
	@GetMapping()
	public String area()
	{
	    return prefix + "/area";
	}
	
	/**
	 * 查询终端地域列表
	 */
	@RequiresPermissions("broad:area:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Area area)
	{
		startPage();
        List<Area> list = areaService.selectAreaList(area);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出终端地域列表
	 */
	@RequiresPermissions("broad:area:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Area area)
    {
    	List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        return util.exportExcel(list, "area");
    }
	
	/**
	 * 新增终端地域
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存终端地域
	 */
	@RequiresPermissions("broad:area:add")
	@Log(title = "终端地域", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Area area)
	{		
		return toAjax(areaService.insertArea(area));
	}

	/**
	 * 修改终端地域
	 */
	@GetMapping("/edit/{aid}")
	public String edit(@PathVariable("aid") String aid, ModelMap mmap)
	{
		Area area = areaService.selectAreaById(aid);
		mmap.put("area", area);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存终端地域
	 */
	@RequiresPermissions("broad:area:edit")
	@Log(title = "终端地域", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Area area)
	{		
		return toAjax(areaService.updateArea(area));
	}
	
	/**
	 * 删除终端地域
	 */
	@RequiresPermissions("broad:area:remove")
	@Log(title = "终端地域", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(areaService.deleteAreaByIds(ids));
	}
	
}
