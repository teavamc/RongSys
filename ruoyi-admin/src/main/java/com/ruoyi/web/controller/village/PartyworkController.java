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
import com.ruoyi.village.domain.Partywork;
import com.ruoyi.village.service.IPartyworkService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 党员值班 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-01-20
 */
@Controller
@RequestMapping("/village/partywork")
public class PartyworkController extends BaseController
{
    private String prefix = "village/partywork";
	
	@Autowired
	private IPartyworkService partyworkService;
	
	@RequiresPermissions("village:partywork:view")
	@GetMapping()
	public String partywork()
	{
	    return prefix + "/partywork";
	}
	
	/**
	 * 查询党员值班列表
	 */
	@RequiresPermissions("village:partywork:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Partywork partywork)
	{
		startPage();
        List<Partywork> list = partyworkService.selectPartyworkList(partywork);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出党员值班列表
	 */
	@RequiresPermissions("village:partywork:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Partywork partywork)
    {
    	List<Partywork> list = partyworkService.selectPartyworkList(partywork);
        ExcelUtil<Partywork> util = new ExcelUtil<Partywork>(Partywork.class);
        return util.exportExcel(list, "partywork");
    }
	
	/**
	 * 新增党员值班
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存党员值班
	 */
	@RequiresPermissions("village:partywork:add")
	@Log(title = "党员值班", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Partywork partywork)
	{		
		return toAjax(partyworkService.insertPartywork(partywork));
	}

	/**
	 * 修改党员值班
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Partywork partywork = partyworkService.selectPartyworkById(id);
		mmap.put("partywork", partywork);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存党员值班
	 */
	@RequiresPermissions("village:partywork:edit")
	@Log(title = "党员值班", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Partywork partywork)
	{		
		return toAjax(partyworkService.updatePartywork(partywork));
	}
	
	/**
	 * 删除党员值班
	 */
	@RequiresPermissions("village:partywork:remove")
	@Log(title = "党员值班", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(partyworkService.deletePartyworkByIds(ids));
	}
	
}
