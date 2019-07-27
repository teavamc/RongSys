package com.ruoyi.web.controller.village;

import java.util.List;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.village.domain.VillagerInfo;
import com.ruoyi.village.service.IVillagerInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 村民 信息操作处理
 * 
 * @author 张鸿权
 * @date 2019-05-02
 */
@Controller
@RequestMapping("/village/villagerInfo")
public class VillagerInfoController extends BaseController
{
    private String prefix = "village/villagerInfo";

	@Autowired
	private IVillagerInfoService villagerInfoService;
	
	@RequiresPermissions("village:villagerInfo:view")
	@GetMapping()
	public String villagerInfo()
	{
	    return prefix + "/villagerInfo";
	}
	
	/**
	 * 查询村民列表
	 */
	@RequiresPermissions("village:villagerInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(VillagerInfo villagerInfo)
	{
		startPage();
        List<VillagerInfo> list = villagerInfoService.selectVillagerInfoList(villagerInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出村民列表
	 */
	@RequiresPermissions("village:villagerInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VillagerInfo villagerInfo)
    {
    	List<VillagerInfo> list = villagerInfoService.selectVillagerInfoList(villagerInfo);
        ExcelUtil<VillagerInfo> util = new ExcelUtil<VillagerInfo>(VillagerInfo.class);
        return util.exportExcel(list, "villagerInfo");
    }
	
	/**
	 * 新增村民
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存村民
	 */
	@RequiresPermissions("village:villagerInfo:add")
	@Log(title = "村民", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(VillagerInfo villagerInfo)
	{		
		return toAjax(villagerInfoService.insertVillagerInfo(villagerInfo));
	}

	/**
	 * 修改村民
	 */
	@GetMapping("/edit/{vid}")
	public String edit(@PathVariable("vid") Integer vid, ModelMap mmap)
	{
		VillagerInfo villagerInfo = villagerInfoService.selectVillagerInfoById(vid);
		mmap.put("villagerInfo", villagerInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存村民
	 */
	@RequiresPermissions("village:villagerInfo:edit")
	@Log(title = "村民", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(VillagerInfo villagerInfo)
	{		
		return toAjax(villagerInfoService.updateVillagerInfo(villagerInfo));
	}
	
	/**
	 * 删除村民
	 */
	@RequiresPermissions("village:villagerInfo:remove")
	@Log(title = "村民", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(villagerInfoService.deleteVillagerInfoByIds(ids));
	}

	/**
	 * 下载模板
	 */
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<VillagerInfo> util = new ExcelUtil<VillagerInfo>(VillagerInfo.class);
		return util.importTemplateExcel("用户数据");
	}

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<VillagerInfo> util = new ExcelUtil<VillagerInfo>(VillagerInfo.class);
        List<VillagerInfo> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据(该功能未实现)
     * @return 结果
     */
    public String importUser(List<VillagerInfo> userList, Boolean isUpdateSupport)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        /*通过读取表格内容获得userlist，再通过遍历userlist去将每一行数据插入数据库中*/
        for (VillagerInfo user : userList)
        {
            try{
                villagerInfoService.insertVillagerInfo(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "用户 " + user.getVname() + " 导入成功");
            }
            catch (Exception e)
            {
                String msg = user.getVname() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        return successMsg.toString();
    }
	/**
	 * 打开项目详情页
	 */
	@GetMapping("/detail/{vid}")
	public String detail(@PathVariable("vid")Integer vid,ModelMap mmap)
	{
		mmap.put("listByid",villagerInfoService.selectVillagerInfoById(vid));
		return prefix + "/detail";
	}
}
