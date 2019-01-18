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
import com.ruoyi.broad.domain.Maintain;
import com.ruoyi.broad.service.IMaintainService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 终端维护记录 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-15
 */
@Controller
@RequestMapping("/broad/maintain")
public class MaintainController extends BaseController
{
    private String prefix = "broad/maintain";

	@Autowired
	private IMaintainService maintainService;

	@RequiresPermissions("broad:maintain:view")
	@GetMapping()
	public String maintain()
	{
	    return prefix + "/maintain";
	}

	/**
	 * 查询终端维护记录列表
	 */
	@RequiresPermissions("broad:maintain:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Maintain maintain)
	{
		startPage();
        List<Maintain> list = maintainService.selectMaintainList(maintain);
		return getDataTable(list);
	}


	/**
	 * 导出终端维护记录列表
	 */
	@RequiresPermissions("broad:maintain:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Maintain maintain)
    {
    	List<Maintain> list = maintainService.selectMaintainList(maintain);
        ExcelUtil<Maintain> util = new ExcelUtil<Maintain>(Maintain.class);
        return util.exportExcel(list, "maintain");
    }

	/**
	 * 新增终端维护记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增保存终端维护记录
	 */
	@RequiresPermissions("broad:maintain:add")
	@Log(title = "终端维护记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Maintain maintain)
	{
		return toAjax(maintainService.insertMaintain(maintain));
	}

	/**
	 * 修改终端维护记录
	 */
	@GetMapping("/edit/{tmid}")
	public String edit(@PathVariable("tmid") Integer tmid, ModelMap mmap)
	{
		Maintain maintain = maintainService.selectMaintainById(tmid);
		mmap.put("maintain", maintain);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存终端维护记录
	 */
	@RequiresPermissions("broad:maintain:edit")
	@Log(title = "终端维护记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Maintain maintain)
	{
		return toAjax(maintainService.updateMaintain(maintain));
	}

	/**
	 * 删除终端维护记录
	 */
	@RequiresPermissions("broad:maintain:remove")
	@Log(title = "终端维护记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(maintainService.deleteMaintainByIds(ids));
	}

}
