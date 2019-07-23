package com.ruoyi.web.controller.village;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.village.domain.Files;
import com.ruoyi.village.domain.Project;
import com.ruoyi.village.util.bFileUtil1;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.village.domain.Worklog;
import com.ruoyi.village.service.IWorklogService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工作记录 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/village/worklog")
public class WorklogController extends BaseController
{
    private String prefix = "village/worklog";
	
	@Autowired
	private IWorklogService worklogService;
	@Autowired
	private ISysUserService sysUserService;
	@RequiresPermissions("village:worklog:view")
	@GetMapping()
	public String worklog()
	{
	    return prefix + "/worklog";
	}
	
	/**
	 * 查询工作记录列表
	 */
	@RequiresPermissions("village:worklog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Worklog worklog)
	{
		//从session中获取当前登陆用户的 userid
		SysUser currentUser = ShiroUtils.getSysUser();
		Long userid =  currentUser.getUserId();
		int returnId = new Long(userid).intValue();
		//通过所获取的userid去用户表中查询用户所属区域的Roleid
		int roleid = sysUserService.selectRoleid(returnId);
		if(worklog.getAid() == null && (roleid == 1)) {
			startPage();
			List<Worklog> list = worklogService.selectWorklogList(worklog);
			return getDataTable(list);
		}else if(worklog.getAid() != null){
			startPage();
			List<Worklog> list = worklogService.selectWorklogList(worklog);
			return getDataTable(list);
		}else{
			String aid;
			//通过所获取的userid去用户表中查询用户所属区域的Aid
			aid = sysUserService.selectAid(returnId);
			worklog.setAid(aid);
			startPage();
			List<Worklog> list = worklogService.selectWorklogList(worklog);
			return getDataTable(list);
		}
	}
	
	
	/**
	 * 导出工作记录列表
	 */
	@RequiresPermissions("village:worklog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Worklog worklog)
    {
    	List<Worklog> list = worklogService.selectWorklogList(worklog);
        ExcelUtil<Worklog> util = new ExcelUtil<Worklog>(Worklog.class);
        return util.exportExcel(list, "worklog");
    }
	
	/**
	 * 新增工作记录
	 */
	/*@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}*/

	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		//从session中获取当前登陆用户的 username、phone、userid
		SysUser currentUser = ShiroUtils.getSysUser();
		String username =  currentUser.getUserName();
		String phone =  currentUser.getPhonenumber();
		Long userid =  currentUser.getUserId();
		String aid;
		int returnId = new Long(userid).intValue();
		//通过所获取的userid去广播用户表中查询用户所属区域的Aid
		aid = sysUserService.selectAid(returnId);
		//	将aid、fname、uname传至add.html中
		mmap.put("aid", aid);//这里获得的aid是来自ry-》tb_user_admin
		mmap.put("wname", username);
		mmap.put("wphone", phone);
		mmap.put("uname", username);
		return prefix + "/add";
	}

	/**
	 * 新增保存工作记录
	 */
	@RequiresPermissions("village:worklog:add")
	@Log(title = "工作记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Worklog worklog)
	{		
		return toAjax(worklogService.insertWorklog(worklog));
	}
	/*这里加入Project project是为了获得html页面form返回来的数据*/
	public AjaxResult addSave(Worklog worklog, @RequestParam(value = "files") MultipartFile file,
							  @RequestParam(value = "filename", required = false) String fname,
							  @RequestParam(value = "flenth" ,required = false)String flenth, //时长
							  @RequestParam(value = "fsize",required = false) String fsize) {//大小
		String year = DateUtil.getYear();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		System.out.println(dateFormat.format(date));
		String maxfileid = dateFormat.format(date); //获取文件上传时的时间参数字符串作为文件名

		//图片上传调用工具类
		try {
			//保存图片
			Files g = bFileUtil1.uplodeFile(maxfileid, file, fname, flenth, fsize, year);
			System.out.println(g.toString());//在控制台输出文件信息

			worklog.setWpic(g.getAddress());//给project实体的“文件地址”赋值

			return toAjax(worklogService.insertWorklog(worklog));//将project实体中的值插入数据表中
		} catch (Exception e) {
			//return "上传图片失败";
			System.out.println("失败");
			return toAjax(0);
		}
	}

	/**
	 * 修改工作记录
	 */
	@GetMapping("/edit/{wid}")
	public String edit(@PathVariable("wid") Integer wid, ModelMap mmap)
	{
		Worklog worklog = worklogService.selectWorklogById(wid);
		mmap.put("worklog", worklog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工作记录
	 */
	@RequiresPermissions("village:worklog:edit")
	@Log(title = "工作记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Worklog worklog)
	{		
		return toAjax(worklogService.updateWorklog(worklog));
	}
	
	/**
	 * 删除工作记录
	 */
	@RequiresPermissions("village:worklog:remove")
	@Log(title = "工作记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(worklogService.deleteWorklogByIds(ids));
	}

	/**
	 * 打开项目详情页
	 */
	@GetMapping("/detail/{wid}")
	public String detail(@PathVariable("wid")Integer wid,ModelMap mmap)
	{
		mmap.put("listByid",worklogService.selectWorklogById(wid));
		return prefix + "/detail";
	}
}
