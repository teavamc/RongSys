package com.ruoyi.web.controller.broad;

import java.util.List;
import java.util.Map;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.common.support.Convert;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;
import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 终端地域 信息操作处理
 *
 * @author 张鸿权
 * @date 2019-02-17
 */
@Controller
@RequestMapping("/broad/organization")
public class OrganizationController extends BaseController
{
	private String prefix = "broad/organization";

	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IAreaService areaService;

	@RequiresPermissions("broad:organization:view")
	@GetMapping()
	public String organization()
	{
		return prefix + "/organization";
	}

	/**
	 * 查询终端地域列表
	 */
	@RequiresPermissions("broad:organization:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Organization organization)
	{
		startPage() ;
		List<Organization> list = organizationService.selectOrganizationList(organization);
		return getDataTable(list);
	}


	/**
	 * 导出终端地域列表
	 */
	@RequiresPermissions("broad:organization:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Organization organization)
	{
		List<Organization> list = organizationService.selectOrganizationList(organization);
		ExcelUtil<Organization> util = new ExcelUtil<Organization>(Organization.class);
		return util.exportExcel(list, "organization");
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
	@RequiresPermissions("broad:organization:add")
	@Log(title = "终端地域", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Organization organization)
	{
		organizationService.insertOrganizationPic(organization);
		return toAjax(organizationService.insertOrganization(organization));
	}

	/**
	 * 修改终端地域
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") String tid, ModelMap mmap)
	{
		Organization organization = organizationService.selectOrganizationById(tid);
		mmap.put("organization", organization);
		return prefix + "/edit";
	}

	/**
	 * 修改保存终端地域
	 */
	@RequiresPermissions("broad:organization:edit")
	@Log(title = "终端地域", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Organization organization)
	{
		return toAjax(organizationService.updateOrganization(organization));
	}

	/**
	 * 删除终端地域
	 */
	@RequiresPermissions("broad:organization:remove")
	@Log(title = "终端地域", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(organizationService.deleteOrganizationByIds(ids));
	}

	/**
	 * 选择部门树
	 */
	@GetMapping("/selectOrganizationTree/{aid}")
	public String selectOrganizationTree(@PathVariable("aid") String aid, ModelMap mmap)
	{
		mmap.put("organization", areaService.selectAreaById("01"));
		/*return prefix + "/tree";*/
		return prefix + "/listProBroadTree";
	}

	/**
	 * 加载节目单播出终端选择列表树
	 */
	@GetMapping("/listProBroadTree")
	@ResponseBody
	public List<Map<String, Object>> listProBroadTree()
	{
		List<Map<String, Object>> tree = areaService.selectAreaTree(new Area());
		return tree;
	}

	/**
	 * 查询节目单终端列表
	 */
	@PostMapping("/listProBroad")
	@ResponseBody
	public TableDataInfo listProBroad(Organization organization)
	{
		startPage() ;
		List<Organization> list = organizationService.selectProBroadList(organization);
		return getDataTable(list);
	}


	/**
	 * 加载部门列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData()
	{
		List<Map<String, Object>> tree = areaService.selectAreaTree(new Area());
		return tree;
	}

	/**
	 * 选择区域树
	 */
	@GetMapping("/selectAidTree")
	public String selectAidTree()
	{
		return prefix + "/aidTree";
	}

    /**
     * 设置终端的RDS码
     */
    @PostMapping( "/rdsSet")
    @ResponseBody
    public AjaxResult rdsSetUrl(String ids, String number)
    {
        return toAjax(organizationService.updateRdsByIds(ids,number));
    }

    /**
     * 设置终端的fmfrequency码
     */
    @PostMapping( "/fmfrequencySet")
    @ResponseBody
    public AjaxResult fmfrequencySet(String ids, String number)
    {
        return toAjax(organizationService.updateFmfrequencyByIds(ids,number));
    }

	@PostMapping( "/isuseSet")
	@ResponseBody
	public AjaxResult isuseSet(String tid, Boolean isuse)
	{
		return toAjax(organizationService.updateIsuseByTid(tid,isuse));
	}
}
