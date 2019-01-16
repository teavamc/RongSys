package com.ruoyi.api.controller.broad;

import com.ruoyi.broad.domain.Conditions;
import com.ruoyi.broad.service.IConditionsService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.domain.server.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gps")
public class gps extends BaseController
{
    @Autowired
    private IConditionsService conditionsService;

    @GetMapping()
    public List<Conditions> searchrandom()
    {
        System.out.println("我被调用了啊！！！！！！！！！！！！！！");
        List<Conditions> search = conditionsService.selectConditionsByRandom();
        System.out.println("对象实例了啊！！！！！！！！！！");
        return search;
    }


}