package com.ruoyi.web.controller.rivervis;

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
import com.ruoyi.rivervis.domain.EnvData;
import com.ruoyi.rivervis.service.IEnvDataService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 环境监测 信息操作处理
 * 
 * @author 张超
 * @date 2019-03-05
 */
@Controller
@RequestMapping("/rivervis/envData")
public class EnvDataController extends BaseController
{
    private String prefix = "rivervis/envData";
	
	@Autowired
	private IEnvDataService envDataService;
	
	@RequiresPermissions("rivervis:envData:view")
	@GetMapping()
	public String envData()
	{
	    return prefix + "/envData";
	}
	
	/**
	 * 查询环境监测列表
	 */
	@RequiresPermissions("rivervis:envData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(EnvData envData)
	{
		startPage();
        List<EnvData> list = envDataService.selectEnvDataList(envData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出环境监测列表
	 */
	@RequiresPermissions("rivervis:envData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnvData envData)
    {
    	List<EnvData> list = envDataService.selectEnvDataList(envData);
        ExcelUtil<EnvData> util = new ExcelUtil<EnvData>(EnvData.class);
        return util.exportExcel(list, "envData");
    }
	
	/**
	 * 新增环境监测
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存环境监测
	 */
	@RequiresPermissions("rivervis:envData:add")
	@Log(title = "环境监测", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(EnvData envData)
	{		
		return toAjax(envDataService.insertEnvData(envData));
	}

	/**
	 * 修改环境监测
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		EnvData envData = envDataService.selectEnvDataById(id);
		mmap.put("envData", envData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存环境监测
	 */
	@RequiresPermissions("rivervis:envData:edit")
	@Log(title = "环境监测", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(EnvData envData)
	{		
		return toAjax(envDataService.updateEnvData(envData));
	}
	
	/**
	 * 删除环境监测
	 */
	@RequiresPermissions("rivervis:envData:remove")
	@Log(title = "环境监测", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(envDataService.deleteEnvDataByIds(ids));
	}
	
}
