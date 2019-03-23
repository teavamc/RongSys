package com.ruoyi.web.controller.broad;

import java.util.List;

import com.ruoyi.broad.domain.ProApplyUser;
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
import com.ruoyi.broad.domain.ProreApply;
import com.ruoyi.broad.service.IProreApplyService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 节目申请 信息操作处理
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Controller
@RequestMapping("/broad/proreApply")
public class ProreApplyController extends BaseController
{
    private String prefix = "broad/proreApply";
	
	@Autowired
	private IProreApplyService proreApplyService;
	
	@RequiresPermissions("broad:proreApply:view")
	@GetMapping()
	public String proreApply()
	{
	    return prefix + "/proreApply";
	}
	
	/**
	 * 查询节目申请列表
	 */
	@RequiresPermissions("broad:proreApply:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProApplyUser proapplyuser)
	{
		startPage();
        List<ProApplyUser> list = proreApplyService.selectProrApplyUserList(proapplyuser);
		return getDataTable(list);
	}

//	/**
//	 * 查询节目申请列表
//	 */
//	@RequiresPermissions("broad:proreApply:list")
//	@PostMapping("/list")
//	@ResponseBody
//	public TableDataInfo list(ProreApply proreApply)
//	{
//		startPage();
//		List<ProreApply> list = proreApplyService.selectProreApplyList(proreApply);
//		return getDataTable(list);
//	}
	
	
	/**
	 * 导出节目申请列表
	 */
	@RequiresPermissions("broad:proreApply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProreApply proreApply)
    {
    	List<ProreApply> list = proreApplyService.selectProreApplyList(proreApply);
        ExcelUtil<ProreApply> util = new ExcelUtil<ProreApply>(ProreApply.class);
        return util.exportExcel(list, "proreApply");
    }
	
	/**
	 * 新增节目申请
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存节目申请
	 */
	@RequiresPermissions("broad:proreApply:add")
	@Log(title = "新增节目申请", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProreApply proreApply)
	{		
		return toAjax(proreApplyService.insertProreApply(proreApply));
	}

	/**
	 * 修改节目申请
	 */
	@GetMapping("/edit/{paid}")
	public String edit(@PathVariable("paid") Integer paid, ModelMap mmap)
	{
		ProreApply proreApply = proreApplyService.selectProreApplyById(paid);
		mmap.put("proreApply", proreApply);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存节目申请
	 */
	@RequiresPermissions("broad:proreApply:edit")
	@Log(title = "修改节目申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProreApply proreApply)
	{		
		return toAjax(proreApplyService.updateProreApply(proreApply));
	}
	
	/**
	 * 删除节目申请
	 */
	@RequiresPermissions("broad:proreApply:remove")
	@Log(title = "删除节目申请", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(proreApplyService.deleteProreApplyByIds(ids));
	}
	
}
