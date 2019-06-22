package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;

import com.ruoyi.village.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
@Api(value = "村务模块 - 项目")
public class Project {
    @Autowired
    private IProjectService projectService;

    @GetMapping("/all")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public RongApiRes searchAll(com.ruoyi.village.domain.Project project )
    {
        return RongApiService.get_list(projectService.selectProjectList(project));
    }

    @PostMapping("/insert")
    @CrossOrigin
    @ApiOperation(value = "返回所有项目")
    public RongApiRes insertProject(com.ruoyi.village.domain.Project project )
    {
        return RongApiService.get_bean(projectService.insertProject(project));
    }
}
