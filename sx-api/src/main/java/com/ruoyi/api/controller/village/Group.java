package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;

import com.ruoyi.village.domain.Partymember;
import com.ruoyi.village.service.IPartymemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
@CrossOrigin
@Api(value = "党建模块 - 党员小组API类")
public class Group {
    @Autowired
    private IPartymemberService partymemberService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "党员信息")
    public RongApiRes searchAll(Partymember partymember)
    {
        return RongApiService.get_list(partymemberService.selectPartymemberList(partymember));
    }

    @GetMapping("/grouplist")
    @CrossOrigin
    @ApiOperation(value = "党员小组")
    public RongApiRes selectGrouplist()
    {
        return RongApiService.get_list(partymemberService.selectGrouplist());
    }
}
