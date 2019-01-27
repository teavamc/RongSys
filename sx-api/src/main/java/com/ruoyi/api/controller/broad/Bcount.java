package com.ruoyi.api.controller.broad;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;

import com.ruoyi.broad.service.IManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张超 teavamc
 * @Description:应急广播的数据统计接口
 * @ClassName Count
 * @date 2019/1/26 10:31
 **/
@RestController
@RequestMapping("/api/bcount")
@CrossOrigin
@Api(value = "应急广播的数据统计接口")
public class Bcount {

    @Autowired
    private IManagementService managementService;

    /**
        * 返回首页需要的统计数据
        * @author 张超 teavamc
        * @date 2019/1/26
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */

    @GetMapping(value = "/bindex")
    @CrossOrigin
    @ApiOperation(value = "返回首页需要的统计数据")
    public RongApiRes bindex(){
        return RongApiService.get_bean(managementService.count());
    }

}
