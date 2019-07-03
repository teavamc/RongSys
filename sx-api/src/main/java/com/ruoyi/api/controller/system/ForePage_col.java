package com.ruoyi.api.controller.system;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.system.service.ISysForePagecolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/forePage_col")
@RestController
@Api(value = "前台磁贴页面控制")
@CrossOrigin
public class ForePage_col {

    @Autowired
    private ISysForePagecolService sysForePagecolService;

    @CrossOrigin
    @GetMapping("/pagestatus")
    @ApiOperation(value = "统计所有山洪数据")
    public RongApiRes getForePageStatus(){
        return RongApiService.get_list(sysForePagecolService.selectForePageStatus());
    }
}
