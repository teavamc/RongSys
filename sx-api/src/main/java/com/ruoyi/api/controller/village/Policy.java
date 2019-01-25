package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Policyinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.village.service.IPolicyinfoService;

import java.util.List;

/**
 * 村务系统中系统公告功能的接口
         *
         * @author 张超
        */
@RestController
@RequestMapping("/api/policy")
@CrossOrigin
public class Policy extends BaseController {

    @Autowired
    private IPolicyinfoService policyinfoService;


    /**
     * 按照时间排序查询最近的十条信息
     *
     * @author 张超
     */
    @GetMapping("/ten")
    @CrossOrigin
    public RongApiRes searchten()
    {
        return RongApiService.get_list(policyinfoService.selectpoliclimitten());
    }

}
