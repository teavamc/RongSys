package com.ruoyi.api.controller.system;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.framework.web.domain.Server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张超 teavamc
 * @Description: 系统的监控数据接口
 * @ClassName Mon
 * @date 2019/1/31 0:13
 **/
@RestController
@RequestMapping("/api/sys_mon")
@CrossOrigin
@Api(value = "系统的监控数据接口")
public class Mon {

    /**
        * 拿到服务器性能的各项参数
        * @author 张超 teavamc
        * @date 2019/1/31
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/mi")
    @ApiOperation(value = "拿到服务器性能的各项参数")
    @CrossOrigin
    public RongApiRes mon_index(){
        Server server = new Server();
        try {
            server.copyTo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RongApiService.get_bean(server);
    }

}
