package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Tempgroup;
import com.ruoyi.broad.service.ITempgroupService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ASUS on 2019/7/30.
 * @author 陈霞
 */
@Controller
@RequestMapping("/broad/tempgroup")
public class TempgroupController extends BaseController{

    private String prefix = "broad/tempgroup";

    @Autowired
    private ITempgroupService iTempgroupService;

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping()
    public String getTempgroup()
    {
        return prefix + "/tempgroup";
    }
    /*
    * 终端临时列表
    *
    * */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Tempgroup> list = iTempgroupService.selectAllTempgroup();
        return getDataTable(list);
    }
}
