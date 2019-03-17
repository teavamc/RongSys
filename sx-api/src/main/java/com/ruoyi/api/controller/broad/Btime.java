package com.ruoyi.api.controller.broad;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.BroadTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 根据时间和地区对广播数目的统计
 * @author 周博
 * @date 2019-01-15
 */
@RestController
@RequestMapping("/api/btime")
@CrossOrigin
@Api(value = "根据时间和地区对广播数目的统计")
public class Btime {
    @Autowired
    private BroadTimeService broadTimeService;

    @CrossOrigin
    @GetMapping("/bt")
    @ApiOperation(value = "根据时间和地区对广播数目的统计")
    public RongApiRes selectList() {
        List pre = broadTimeService.selectList();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/bd")
    @ApiOperation(value = "根据时间和地区对广播数目的统计")
    public RongApiRes selectListByDate() {
        List pre = broadTimeService.selectListByDate();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @GetMapping("/bds")
    @ApiOperation(value = "根据时间和地区对广播数目的统计")
    public RongApiRes selectListByScategory() {
        List pre = broadTimeService.selectListByScategory();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

}
