package com.ruoyi.api.controller.iot;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.iot.domain.IotgetPa;
import com.ruoyi.iot.service.ITorrentService;
import com.ruoyi.rivervis.service.IEnvDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张超 teavamc
 * @Description:物联网模块 - 统计计数类接口
 * @ClassName IotCount
 * @date 2019/3/10 13:32
 **/
@RestController
@RequestMapping("/api/iot")
@CrossOrigin
@Api(value = "物联网模块 - 统计计数类接口")
public class IotCount {


    @Autowired
    private ITorrentService torrentService;

    @CrossOrigin
    @GetMapping("/countall")
    @ApiOperation(value = "统计所有山洪数据")
    public RongApiRes countall(){
        return RongApiService.get_bean(torrentService.countall());
    }


    @CrossOrigin
    @GetMapping("/devicecount")
    @ApiOperation(value = "物联网挂载设备总数")
    public RongApiRes devicecount(){
        return RongApiService.get_bean(torrentService.devicecount());
    }

    @CrossOrigin
    @GetMapping("/iotbyitl")
    @ApiOperation(value = "根据IMEI号和时间范围和查询条数统计物联网数据")
    public RongApiRes iotbyitl(IotgetPa iotgetPa){
        return RongApiService.get_list(torrentService.selectTorrentByitl(iotgetPa));
    }


}
