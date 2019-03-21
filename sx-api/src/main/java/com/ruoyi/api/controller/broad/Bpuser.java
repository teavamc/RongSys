package com.ruoyi.api.controller.broad;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.service.IBuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 广播面板中对广播数目的统计
 *
 * @author 周博
 * @date 2019-03-21
 */

@RestController
@RequestMapping("/api/bp")
@CrossOrigin
@Api(value = "广播面板中对广播数目的统计")
public class Bpuser {
    @Autowired
    private IBuserService buserService;

    @CrossOrigin
    @GetMapping("/bu")
    @ApiOperation(value = "根据用户对广播数目的统计")
    public RongApiRes selectList() {
        List pre = buserService.selectProgramsByUser();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @CrossOrigin
    @GetMapping("/bl")
    @ApiOperation(value = "根据时长对广播数目的统计")
    public RongApiRes selectProgramsByLenth() {
        List pre = buserService.selectProgramsByLenth();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @CrossOrigin
    @GetMapping("/bip")
    @ApiOperation(value = "根据是否公共对广播数目的统计")
    public RongApiRes selectProgramsIfPublic() {
        List pre = buserService.selectProgramsIfPublic();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

    @CrossOrigin
    @GetMapping("/ptp")
    @ApiOperation(value = "广播查询记录")
    public RongApiRes selectProgramsPtp() {
        List pre = buserService.selectProgramsPtp();
        RongApiRes test = RongApiService.get_list(pre);
        return test;
    }

}
