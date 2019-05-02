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
import com.ruoyi.village.domain.AssetAssessment;
import com.ruoyi.village.service.IAssetAssessmentService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 资产清查 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/assetAssessment")
public class AssetAssessmentController extends BaseController
{
    private String prefix = "village/assetAssessment";
	
	@Autowired
	private IAssetAssessmentService assetAssessmentService;
	
	@RequiresPermissions("village:assetAssessment:view")
	@GetMapping()
	public String assetAssessment()
	{
	    return prefix + "/assetAssessment";
	}
	
	/**
	 * 查询资产清查列表
	 */
	@RequiresPermissions("village:assetAssessment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AssetAssessment assetAssessment)
	{
		startPage();
        List<AssetAssessment> list = assetAssessmentService.selectAssetAssessmentList(assetAssessment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资产清查列表
	 */
	@RequiresPermissions("village:assetAssessment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetAssessment assetAssessment)
    {
    	List<AssetAssessment> list = assetAssessmentService.selectAssetAssessmentList(assetAssessment);
        ExcelUtil<AssetAssessment> util = new ExcelUtil<AssetAssessment>(AssetAssessment.class);
        return util.exportExcel(list, "assetAssessment");
    }
	
	/**
	 * 新增资产清查
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存资产清查
	 */
	@RequiresPermissions("village:assetAssessment:add")
	@Log(title = "资产清查", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AssetAssessment assetAssessment)
	{		
		return toAjax(assetAssessmentService.insertAssetAssessment(assetAssessment));
	}

	/**
	 * 修改资产清查
	 */
	@GetMapping("/edit/{aaid}")
	public String edit(@PathVariable("aaid") Integer aaid, ModelMap mmap)
	{
		AssetAssessment assetAssessment = assetAssessmentService.selectAssetAssessmentById(aaid);
		mmap.put("assetAssessment", assetAssessment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资产清查
	 */
	@RequiresPermissions("village:assetAssessment:edit")
	@Log(title = "资产清查", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AssetAssessment assetAssessment)
	{		
		return toAjax(assetAssessmentService.updateAssetAssessment(assetAssessment));
	}
	
	/**
	 * 删除资产清查
	 */
	@RequiresPermissions("village:assetAssessment:remove")
	@Log(title = "资产清查", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(assetAssessmentService.deleteAssetAssessmentByIds(ids));
	}
	
}
