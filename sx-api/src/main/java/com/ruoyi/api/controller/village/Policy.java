package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Policyinfo;
import com.ruoyi.village.domain.Politics;
import com.ruoyi.village.service.IPoliticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.village.service.IPolicyinfoService;

import java.util.List;

/**
 * 村务模块中公告功能的接口
 *
 * @author 张超
*/
@RestController
@RequestMapping("/api/policy")
@CrossOrigin
@Api(value = "村务模块 - 公告功能API类")
public class Policy extends BaseController {

    @Autowired
    private IPolicyinfoService policyinfoService;

    @Autowired
    private IPoliticsService politicsService;

    /**
        * 返回最近的十条政策公告
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/ten")
    @CrossOrigin
    @ApiOperation(value = "返回最近的十条公告")
    public RongApiRes searchten()
    {
        return RongApiService.get_list(policyinfoService.selectpoliclimitten());
    }

    @GetMapping("/infoAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有公告")
    public RongApiRes searchAll(Policyinfo policyinfo)
    {
        return RongApiService.get_list(policyinfoService.selectPolicyinfoList(policyinfo));
    }

    @PostMapping("/infoInsert")
    @CrossOrigin
    @ApiOperation(value = "新增公告")
    public RongApiRes insertPolicy(Policyinfo policyinfo)
    {
        return RongApiService.get_bean(policyinfoService.insertpolicyinfo(policyinfo));
    }

    @GetMapping("/PolAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有政策")
    public RongApiRes selectPoliticsList(Politics politics)
    {
        return RongApiService.get_list(politicsService.selectPoliticsList(politics));
    }

    @PostMapping("/PolInsert")
    @CrossOrigin
    @ApiOperation(value = "新增政策")
    public RongApiRes insertpolitics(Politics politics)
    {
        return RongApiService.get_bean(politicsService.insertpolitics(politics));
    }
}
