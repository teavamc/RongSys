package com.ruoyi.api.controller.village;

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

@RestController
@RequestMapping("/api/policy")
@CrossOrigin
public class policy extends BaseController {

    @Autowired
    private IPolicyinfoService policyinfoService;

    @GetMapping("/limit")
    public List<Policyinfo> searchten()
    {
        List<Policyinfo> search = policyinfoService.selectpoliclimitten();
        return search;
    }

}
