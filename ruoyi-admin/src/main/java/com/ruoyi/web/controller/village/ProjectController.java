package com.ruoyi.web.controller.village;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.ruoyi.village.util.bFileUtil1;
import com.ruoyi.common.utils.DateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.village.domain.Project;
import com.ruoyi.village.domain.Files;
import com.ruoyi.village.service.IProjectService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 重大项目 信息操作处理
 *
 * @author 张鸿权
 * @date 2019-01-19
 */
@Controller
@RequestMapping("/village/project")
public class ProjectController extends BaseController
{
	private String prefix = "village/project";

	@Autowired
	private IProjectService projectService;

	@RequiresPermissions("village:project:view")
	@GetMapping()
	public String project()
	{
		return prefix + "/project";
	}

	/**
	 * 查询重大项目列表
	 */
	@RequiresPermissions("village:project:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Project project)
	{
		startPage();
		List<Project> list = projectService.selectProjectList(project);
		return getDataTable(list);
	}


	/**
	 * 导出重大项目列表
	 */
	@RequiresPermissions("village:project:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Project project)
	{
		List<Project> list = projectService.selectProjectList(project);
		ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
		return util.exportExcel(list, "project");
	}

	/**
	 * 新增重大项目
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存重大项目
	 */
	@Log(title = "新增项目", businessType = BusinessType.INSERT)
	@PostMapping(value = "/add")
	@ResponseBody
    /*这里加入Project project是为了获得html页面form返回来的数据*/
	public AjaxResult addSave(Project project,@RequestParam(value = "files") MultipartFile file,
							  @RequestParam(value = "filename", required = false) String fname,
							  @RequestParam(value = "flenth" ,required = false)String flenth, //时长
							  @RequestParam(value = "fsize",required = false) String fsize){//大小
		String year = DateUtil.getYear();

		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
		System.out.println(dateFormat.format(date));
		String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名

        //图片上传调用工具类
		try{
			//保存图片
			Files g = bFileUtil1.uplodeFile(maxfileid,file,fname,flenth,fsize,year);
			System.out.println(g.toString());//在控制台输出文件信息

			project.setPropic(g.getAddress());//给project实体的“文件地址”赋值

			return toAjax(projectService.insertProject(project));//将project实体中的值插入数据表中
		}catch (Exception e){
			//return "上传图片失败";
			System.out.println("失败");
			return toAjax(0);
		}

	}
	/**
	 * 修改重大项目
	 */
	@GetMapping("/edit/{proid}")
	public String edit(@PathVariable("proid") Integer proid, ModelMap mmap)
	{
		Project project = projectService.selectProjectById(proid);
		mmap.put("project", project);
		return prefix + "/edit";
	}

	/**
	 * 修改保存重大项目
	 */
	@RequiresPermissions("village:project:edit")
	@Log(title = "重大项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Project project)
	{
		return toAjax(projectService.updateProject(project));
	}

	/**
	 * 删除重大项目
	 */
	@RequiresPermissions("village:project:remove")
	@Log(title = "重大项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(projectService.deleteProjectByIds(ids));
	}

}
