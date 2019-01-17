package com.ruoyi.api.controller.broad;

import com.ruoyi.broad.domain.Conditions;
import com.ruoyi.broad.service.IConditionsService;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<Conditions> search = conditionsService.selectConditionsByRandom();
        return search;
    }


}