package com.ruoyi.web.controller.broad;
import com.ruoyi.broad.domain.Termap;
import com.ruoyi.broad.service.ITermapService;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 地图管理 服务层
 *
 * @author 张鸿权
 * @date 2019-01-18
 */
@Controller
@RequestMapping("/broad/map")
public class TermapController extends BaseController
{
	@Autowired
	private ITermapService mapService;
	private String preurl = "broad/map";

	@GetMapping("/list")
	public String list(ModelMap mmap)
	{
		// 根据用户id取出菜单
		List<Termap> mapinfoList = mapService.selectMap();
		mmap.put("mapinfoList", mapinfoList);
		return preurl+"/termap";
	}
}
