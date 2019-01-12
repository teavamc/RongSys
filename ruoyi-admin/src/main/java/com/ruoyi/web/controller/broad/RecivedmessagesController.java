package com.ruoyi.web.controller.broad;

import java.util.List;
import com.ruoyi.broad.domain.Recivedmessages;
import com.ruoyi.broad.service.IRecivedmessagesService;
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
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 短信接收记录 信息操作处理
 * 
 * @author 张超
 * @date 2019-01-11
 */
@Controller
@RequestMapping("/broad/recivedmessages")
public class RecivedmessagesController extends BaseController
{
    private String prefix = "broad/recivedmessages";
	
	@Autowired
	private IRecivedmessagesService recivedmessagesService;
	
	@RequiresPermissions("system:recivedmessages:view")
	@GetMapping()
	public String recivedmessages()
	{
	    return prefix + "/recivedmessages";
	}
	
	/**
	 * 查询短信接收记录列表
	 */
	@RequiresPermissions("system:recivedmessages:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Recivedmessages recivedmessages)
	{
		startPage();
        List<Recivedmessages> list = recivedmessagesService.selectRecivedmessagesList(recivedmessages);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出短信接收记录列表
	 */
	@RequiresPermissions("system:recivedmessages:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Recivedmessages recivedmessages)
    {
    	List<Recivedmessages> list = recivedmessagesService.selectRecivedmessagesList(recivedmessages);
        ExcelUtil<Recivedmessages> util = new ExcelUtil<Recivedmessages>(Recivedmessages.class);
        return util.exportExcel(list, "recivedmessages");
    }
	
	/**
	 * 新增短信接收记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存短信接收记录
	 */
	@RequiresPermissions("system:recivedmessages:add")
	@Log(title = "短信接收记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Recivedmessages recivedmessages)
	{		
		return toAjax(recivedmessagesService.insertRecivedmessages(recivedmessages));
	}

	/**
	 * 修改短信接收记录
	 */
	@GetMapping("/edit/{rmid}")
	public String edit(@PathVariable("rmid") Integer rmid, ModelMap mmap)
	{
		Recivedmessages recivedmessages = recivedmessagesService.selectRecivedmessagesById(rmid);
		mmap.put("recivedmessages", recivedmessages);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存短信接收记录
	 */
	@RequiresPermissions("system:recivedmessages:edit")
	@Log(title = "短信接收记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Recivedmessages recivedmessages)
	{		
		return toAjax(recivedmessagesService.updateRecivedmessages(recivedmessages));
	}
	
	/**
	 * 删除短信接收记录
	 */
	@RequiresPermissions("system:recivedmessages:remove")
	@Log(title = "短信接收记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(recivedmessagesService.deleteRecivedmessagesByIds(ids));
	}
	
}
