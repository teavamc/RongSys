package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Program;
import com.ruoyi.broad.service.IProgramService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.web.base.BaseController;
import java.util.List;

/**
 * @author 刘衍斌
 * @Description: 节目库管理
 * @ClassName PerController
 * @date 2019/2/17 20:37
 **/
@Controller
@RequestMapping(value="/broad/per")
public class PerController extends BaseController{
    private String prefix = "broad/program/per";

    @Autowired
    private IProgramService iProgramService;

    @RequiresPermissions("broad:per:view")
    @GetMapping()
    public String per()
    {
        return prefix + "/per";
    }

    /**
     * 查询终端地域列表
     */
    @RequiresPermissions("broad:per:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Program program)
    {
        startPage() ;
        List<Program> list = iProgramService.selectProList(program);
        return getDataTable(list);
    }

    /**
     * 返回新增页面
     * @return
     */
    @GetMapping("/add")
    public String addper()
    {
        return prefix + "/add";
    }



}
