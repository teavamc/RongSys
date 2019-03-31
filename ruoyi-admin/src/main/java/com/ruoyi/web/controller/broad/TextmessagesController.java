package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Textmessages;
import com.ruoyi.broad.service.ITextmessagesService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 广播用户 终端信息操作处理
 * 
 * @author 戴誉琪
 * @date 2019-01-18
 */
@Controller
@RequestMapping("/broad/textmessages")
public class TextmessagesController extends BaseController
{
    private String prefix = "broad/textmessages";
	
	@Autowired
	private ITextmessagesService iTextmessagesService;
	//private IBroaduserService broaduserService;
	
	//@RequiresPermissions("broad:broaduser:view")
	@GetMapping()
	public String broaduser(ModelMap mmap)
	{
		mmap.put("typeNum",iTextmessagesService.selectTypeNum());
	    return prefix + "/textmessages";
	}
	@PostMapping("/list")
		@ResponseBody
		public TableDataInfo list() {
			startPage();
			List<Textmessages> list = iTextmessagesService.selectTextMessages();
			return getDataTable(list);
	}

}
