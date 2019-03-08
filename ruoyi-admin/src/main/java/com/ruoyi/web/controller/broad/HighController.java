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
import com.ruoyi.broad.domain.High;
import com.ruoyi.broad.service.IHighService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 上级公告 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-14
 */
@Controller
@RequestMapping("/broad/high")
public class HighController extends BaseController
{
    private String prefix = "broad/high";
	
	@Autowired
	private IHighService highService;
	
	@RequiresPermissions("broad:high:view")
	@GetMapping()
	public String high()
	{
	    return prefix + "/high";
	}
	
	/**
	 * 查询上级公告列表
	 */
	@RequiresPermissions("broad:high:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(High high)
	{
		startPage();
        List<High> list = highService.selectHighList(high);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出上级公告列表
	 */
	@RequiresPermissions("broad:high:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(High high)
    {
    	List<High> list = highService.selectHighList(high);
        ExcelUtil<High> util = new ExcelUtil<High>(High.class);
        return util.exportExcel(list, "high");
    }
	
	/**
	 * 新增上级公告
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存上级公告
	 */
	@RequiresPermissions("broad:high:add")
	@Log(title = "上级公告", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(High high)
	{		
		return toAjax(highService.insertHigh(high));
	}

	/**
	 * 修改上级公告
	 */
	@GetMapping("/edit/{mhid}")
	public String edit(@PathVariable("mhid") Integer mhid, ModelMap mmap)
	{
		High high = highService.selectHighById(mhid);
		mmap.put("high", high);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存上级公告
	 */
	@RequiresPermissions("broad:high:edit")
	@Log(title = "上级公告", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(High high)
	{		
		return toAjax(highService.updateHigh(high));
	}
	
	/**
	 * 删除上级公告
	 */
	@RequiresPermissions("broad:high:remove")
	@Log(title = "上级公告", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(highService.deleteHighByIds(ids));
	}
	
}
