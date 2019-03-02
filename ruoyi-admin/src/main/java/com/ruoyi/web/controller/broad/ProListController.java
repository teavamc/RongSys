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
import com.ruoyi.broad.domain.ProList;
import com.ruoyi.broad.service.IProListService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 节目单记录 信息操作处理
 * 
 * @author 张超
 * @date 2019-03-02
 */
@Controller
@RequestMapping("/broad/proList")
public class ProListController extends BaseController
{
    private String prefix = "broad/proList";
	
	@Autowired
	private IProListService proListService;
	
	@RequiresPermissions("broad:proList:view")
	@GetMapping()
	public String proList()
	{
	    return prefix + "/proList";
	}
	
	/**
	 * 查询节目单记录列表
	 */
	@RequiresPermissions("broad:proList:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProList proList)
	{
		startPage();
        List<ProList> list = proListService.selectProListList(proList);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出节目单记录列表
	 */
	@RequiresPermissions("broad:proList:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProList proList)
    {
    	List<ProList> list = proListService.selectProListList(proList);
        ExcelUtil<ProList> util = new ExcelUtil<ProList>(ProList.class);
        return util.exportExcel(list, "proList");
    }
	
	/**
	 * 新增节目单记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存节目单记录
	 */
	@RequiresPermissions("broad:proList:add")
	@Log(title = "节目单记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProList proList)
	{		
		return toAjax(proListService.insertProList(proList));
	}

	/**
	 * 修改节目单记录
	 */
	@GetMapping("/edit/{pid}")
	public String edit(@PathVariable("pid") Integer pid, ModelMap mmap)
	{
		ProList proList = proListService.selectProListById(pid);
		mmap.put("proList", proList);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存节目单记录
	 */
	@RequiresPermissions("broad:proList:edit")
	@Log(title = "节目单记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProList proList)
	{		
		return toAjax(proListService.updateProList(proList));
	}
	
	/**
	 * 删除节目单记录
	 */
	@RequiresPermissions("broad:proList:remove")
	@Log(title = "节目单记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(proListService.deleteProListByIds(ids));
	}
	
}
