package com.ruoyi.web.controller.broad;

import java.util.List;
import java.util.logging.Logger;

import com.ruoyi.broad.domain.ProList;
import com.ruoyi.broad.service.IProListService;
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
import com.ruoyi.broad.domain.ProSinmanage;
import com.ruoyi.broad.service.IProSinmanageService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 节目播出单 信息操作处理
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Controller
@RequestMapping("/broad/proSinmanage")
public class ProSinmanageController extends BaseController
{
    private String prefix = "broad/proSinmanage";
	
	@Autowired
	private IProSinmanageService proSinmanageService;
	@Autowired
	private IProListService proListService;



	@RequiresPermissions("broad:proSinmanage:view")
	@GetMapping()
	public String proSinmanage()
	{
	    return prefix + "/proSinmanage";
	}
	
	/**
	 * 查询节目播出单列表
	 */
	@RequiresPermissions("broad:proSinmanage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProSinmanage proSinmanage)
	{
		startPage();
        List<ProSinmanage> list = proSinmanageService.selectProSinmanageList(proSinmanage);
		return getDataTable(list);
	}

	/**
	 * 打开节目单详情页
	 */
	@GetMapping("/detail/{sjid}")
	public String detail(@PathVariable("sjid")String sjid,ModelMap mmap)
	{
		mmap.put("sjid",sjid);
		mmap.put("listBySjid",proListService.selectProListListByPid(sjid));
		return prefix + "/detail";
	}

	/**
	 * 导出节目播出单列表
	 */
	@RequiresPermissions("broad:proSinmanage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSinmanage proSinmanage)
    {
    	List<ProSinmanage> list = proSinmanageService.selectProSinmanageList(proSinmanage);
        ExcelUtil<ProSinmanage> util = new ExcelUtil<ProSinmanage>(ProSinmanage.class);
        return util.exportExcel(list, "proSinmanage");
    }
	
	/**
	 * 新增节目播出单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存节目播出单
	 */
	@RequiresPermissions("broad:proSinmanage:add")
	@Log(title = "节目播出单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProSinmanage proSinmanage)
	{		
		return toAjax(proSinmanageService.insertProSinmanage(proSinmanage));
	}


	/*************************************************************************************************
	 * 新增节目播出单
	 */
	@GetMapping("/addtest")
	public String addtest()
	{
		return prefix + "/addtest";
	}

	/*************************************************************************************************
	 * 新增保存节目播出单
	 */
//	@RequiresPermissions("broad:proSinmanage:addtest")
	@Log(title = "新增节目播出单测试", businessType = BusinessType.INSERT)
	@PostMapping("/addtest")
	@ResponseBody
	public AjaxResult addtestSave(ProSinmanage proSinmanage)
	{
		return toAjax(proSinmanageService.insertProSinmanage(proSinmanage));
	}

	/**
	 * 修改节目播出单
	 */
	@GetMapping("/edit/{sfid}")
	public String edit(@PathVariable("sfid") Integer sfid, ModelMap mmap)
	{
		ProSinmanage proSinmanage = proSinmanageService.selectProSinmanageById(sfid);
		mmap.put("proSinmanage", proSinmanage);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存节目播出单
	 */
	@RequiresPermissions("broad:proSinmanage:edit")
	@Log(title = "节目播出单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProSinmanage proSinmanage)
	{		
		return toAjax(proSinmanageService.updateProSinmanage(proSinmanage));
	}
	
	/**
	 * 删除节目播出单
	 */
	@RequiresPermissions("broad:proSinmanage:remove")
	@Log(title = "节目播出单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(proSinmanageService.deleteProSinmanageByIds(ids));
	}
	
}
