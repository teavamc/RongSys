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
import com.ruoyi.broad.domain.Traffic;
import com.ruoyi.broad.service.ITrafficService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 流量 信息操作处理
 *
 * @author 张超
 * @date 2019-01-15
 */
@Controller
@RequestMapping("/broad/traffic")
public class TrafficController extends BaseController
{
	private String prefix = "broad/traffic";

	@Autowired
	private ITrafficService trafficService;

	@RequiresPermissions("broad:traffic:view")
	@GetMapping()
	public String traffic()
	{
		return prefix + "/traffic";
	}

	/**
	 * 查询流量列表
	 */
	@RequiresPermissions("broad:traffic:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Traffic traffic)
	{
		startPage();
		List<Traffic> list = trafficService.selectTrafficList(traffic);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getUsetraffic()>list.get(i).getTrafficlimit())
			{
				list.get(i).setStatus("1");
			}else{
				list.get(i).setStatus("0");
			}
		}
		return getDataTable(list);
	}


	/**
	 * 导出流量列表
	 */
	@RequiresPermissions("broad:traffic:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Traffic traffic)
	{
		List<Traffic> list = trafficService.selectTrafficList(traffic);
		ExcelUtil<Traffic> util = new ExcelUtil<Traffic>(Traffic.class);
		return util.exportExcel(list, "traffic");
	}

	/**
	 * 新增流量
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存流量
	 */
	@RequiresPermissions("broad:traffic:add")
	@Log(title = "流量", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Traffic traffic)
	{
		return toAjax(trafficService.insertTraffic(traffic));
	}

	/**
	 * 修改流量
	 */
	@GetMapping("/edit/{ttid}")
	public String edit(@PathVariable("ttid") Integer ttid, ModelMap mmap)
	{
		Traffic traffic = trafficService.selectTrafficById(ttid);
		mmap.put("traffic", traffic);
		return prefix + "/edit";
	}

	/**
	 * 修改保存流量
	 */
	@RequiresPermissions("broad:traffic:edit")
	@Log(title = "流量", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Traffic traffic)
	{
		trafficService.updateTrafficSet(traffic);
		return toAjax(trafficService.updateTraffic(traffic));
	}

	/**
	 * 删除流量
	 */
	@RequiresPermissions("broad:traffic:remove")
	@Log(title = "流量", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(trafficService.deleteTrafficByIds(ids));
	}

}
