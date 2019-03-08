package com.ruoyi.api.controller.system;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.system.service.ISysLogininforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张超 teavamc
 * @Description: 一些系统记录的接口
 * @ClassName Log
 * @date 2019/1/31 16:02
 **/
@RequestMapping("/api/sys_log")
@RestController
@Api(value = "一些系统记录的接口")
@CrossOrigin
public class Log {

    @Autowired
    private ISysLogininforService logininforService;

    /**
        * 此接口能够展示最近的系统登录记录信息
        * @author 张超 teavamc
        * @date 2019/1/31
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping(value = "/l_log")
    @CrossOrigin
    @ApiOperation(value = "此接口能够展示最近的系统登录记录信息")
    public RongApiRes login_log(){
        return RongApiService.get_list(logininforService.selectLoginLogforIndex());
    }
}
