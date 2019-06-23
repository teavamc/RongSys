package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IPersonalDetailService;
import com.ruoyi.village.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
@Api(value = "个人信息API类")
public class Person {
    @Autowired
    private IPersonalDetailService personalDetailService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "查询个人详细信息")
    public RongApiRes searchPerson(Integer pdid)
    {
        return RongApiService.get_bean(personalDetailService.selectPersonalDetailById(pdid));
    }
}
