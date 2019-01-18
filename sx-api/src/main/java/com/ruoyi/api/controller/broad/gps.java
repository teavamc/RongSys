package com.ruoyi.api.controller.broad;

import com.ruoyi.broad.domain.Conditions;
import com.ruoyi.broad.domain.Management;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.broad.service.IConditionsService;

import com.ruoyi.broad.service.IManagementService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.domain.server.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gps")
@CrossOrigin
public class gps extends BaseController
{
    @Autowired
    private IManagementService managementService;

    @GetMapping("/rondom")
    public List<Managementgps> searchrandom()
    {
        List<Managementgps> search = managementService.selectManagementByRandom();
        return search;
    }

    @GetMapping("/searchall")
    public List<Managementgps> searchall()
    {
        List<Managementgps> search = managementService.selectManagementAll();
        return search;
    }


}